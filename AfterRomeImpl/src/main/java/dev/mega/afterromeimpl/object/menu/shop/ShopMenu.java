package dev.mega.afterromeimpl.object.menu.shop;

import dev.mega.afterrome.api.AfterRomeAPI;
import dev.mega.afterrome.user.User;
import dev.mega.afterromeimpl.object.menu.AbstractMenu;
import dev.mega.megacore.inventory.builder.menu.MenuItemBuilder;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.util.Optional;

public class ShopMenu extends AbstractMenu {
    public ShopMenu(User user, int rows) {
        super(user, rows);
    }

    @Override
    protected void setMenuItems() {
        //TODO Брать и ставить предметы?
    }

    @Override
    public String getTitle() {
        return "";
    }

    @Override
    public void handleBottomClick(InventoryClickEvent event) {
        if (!allowClicks) event.setCancelled(true);

        Optional<User> optuser = AfterRomeAPI.getUser((Player) event.getView());
        if (optuser.isEmpty()) return;
        User user = optuser.get();

        Inventory bottomInventory = event.getView().getBottomInventory();

        MenuItemBuilder clickedItem = new MenuItemBuilder(bottomInventory.getContents()[event.getSlot()]);

//        HashMap<ItemStack, Integer> saleItems = user.getProfession().getSaleConfig().getSaleItems();
//
//        for (ItemStack itemStack : saleItems.keySet()) {
//            if (!itemStack.asOne().equals(clickedItem.toItemStack().asOne())) return;
//
//            SaleTransactionManager saleTransactionManager = MegaManager.getManager(SaleTransactionManager.class);
//
//            clickedItem.addClickAction(saleTransactionManager.getTransactionAction(
//                    user, itemStack, clickedItem.toItemStack(),
//                    saleItems.get(itemStack), event.getSlot()));
//
//            clickedItem.addShiftClickAction(saleTransactionManager.getAllTransactionAction(
//                    user, itemStack, clickedItem.toItemStack(),
//                    saleItems.get(itemStack), event.getSlot()));
//
//            clickedItem.doClickActions(event); //TODO получать предметы по профессии из конфига и обрабатывать их
//        }
    }
}
