package dev.mega.afterrome.impl.menu.shop;

import dev.mega.afterrome.core.api.AfterRomeAPI;
import dev.mega.afterrome.core.config.Config;
import dev.mega.afterrome.core.config.data.ConfigData;
import dev.mega.afterrome.core.config.data.ProfessionSection;
import dev.mega.afterrome.core.config.menu.item.MenuItemSection;
import dev.mega.afterrome.core.user.User;
import dev.mega.afterrome.impl.manager.SaleTransactionManager;
import dev.mega.afterrome.impl.menu.AbstractMenu;
import dev.mega.megacore.config.SubFolder;
import dev.mega.megacore.inventory.builder.menu.MenuItemBuilder;
import dev.mega.megacore.manager.MegaManager;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ShopMenu extends AbstractMenu {
    public ShopMenu(User user, int rows) {
        super(user, rows);
    }

    @Override
    protected void setMenuItems() {
        ConfigData configData = SubFolder.getConfigManager().getConfig(Config.class).getConfigData();
        List<MenuItemSection> menuItemSections = new ArrayList<>();

        for (ProfessionSection professionSection : configData.getProfessions()) {
            if (professionSection.getName().equals(getUser().getProfession().getName())) {
                menuItemSections = professionSection.getMenuSection().getShopMenuSection().getItems();
            }
        }

        for (MenuItemSection menuItemSection : menuItemSections) {
            setItem(menuItemSection.getItem()
                    .setName(menuItemSection.getName())
                    .setLore(menuItemSection.getLore()),
                    menuItemSection.getSlot());
        }
    }

    @Override
    public String getTitle() {
        ConfigData configData = SubFolder.getConfigManager().getConfig(Config.class).getConfigData();

        for (ProfessionSection professionSection : configData.getProfessions()) {
            if (professionSection.getName().equals(getUser().getProfession().getName())) {
                return professionSection.getMenuSection().getShopMenuSection().getMenuName();
            }
        }

        return "check your config";
    }

    @Override
    public void handleBottomClick(InventoryClickEvent event) {
        if (!allowClicks) event.setCancelled(true);

        Optional<User> optuser = AfterRomeAPI.getUser((Player) event.getView());
        if (optuser.isEmpty()) return;
        User user = optuser.get();

        Inventory bottomInventory = event.getView().getBottomInventory();
        Config config = SubFolder.getConfigManager().getConfig(Config.class);
        ConfigData configData = config.getConfigData();

        MenuItemBuilder clickedItem = new MenuItemBuilder(bottomInventory.getContents()[event.getSlot()]);

        HashMap<ItemStack, Integer> saleItems = new HashMap<>();

        for (ProfessionSection professionSection : configData.getProfessions()) {
            if (professionSection.getName().equals(user.getProfession().getName())) {
                saleItems = professionSection.getMenuSection().getShopMenuSection().getSellItems();
            }
        }

        for (ItemStack itemStack : saleItems.keySet()) {
            if (!itemStack.asOne().equals(clickedItem.toItemStack().asOne())) return;

            SaleTransactionManager saleTransactionManager = MegaManager.getManager(SaleTransactionManager.class);

            clickedItem.addClickAction(saleTransactionManager.getTransactionAction(
                    user, itemStack, clickedItem.toItemStack(),
                    saleItems.get(itemStack), event.getSlot()));

            clickedItem.addShiftClickAction(saleTransactionManager.getAllTransactionAction(
                    user, itemStack, clickedItem.toItemStack(),
                    saleItems.get(itemStack), event.getSlot()));

            clickedItem.doClickActions(event);
        }
    }
}
