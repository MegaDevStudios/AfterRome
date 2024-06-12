package dev.mega.afterromeimpl.object.menu.shop;

import com.megadev.afterrome.manager.SaleTransactionManager;
import com.megadev.afterrome.manager.UserManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import dev.mega.afterrome.api.APIHandler;
import dev.mega.afterrome.api.AfterRomeAPI;
import dev.mega.afterrome.user.User;
import dev.mega.afterromeimpl.object.menu.AbstractMenu;
import dev.mega.megacore.manager.MegaManager;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Optional;

public class ShopMenu extends AbstractMenu {
    public ShopMenu(User user) {
        super(user, 3, "");
    }

    @Override
    protected void setMenuItems() {

    }

    @Override
    public void handleBottomClick(InventoryClickEvent event) {
        event.setCancelled(true);

        Optional<User> optionalUser = AfterRomeAPI.getUser((Player) event.getView());
        if (optionalUser.isEmpty()) return;
        User user = optionalUser.get();

        Inventory bottomInventory = event.getView().getBottomInventory();

        MenuItem clickedItem = new MenuItem(bottomInventory.getContents()[event.getSlot()]);

        HashMap<ItemStack, Integer> saleItems = user.getProfession().getSaleConfig().getSaleItems();

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
