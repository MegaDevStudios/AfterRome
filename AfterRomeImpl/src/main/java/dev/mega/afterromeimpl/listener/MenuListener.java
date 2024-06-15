package dev.mega.afterromeimpl.listener;

import dev.mega.afterrome.api.AfterRomeAPI;
import dev.mega.afterrome.user.User;
import dev.mega.afterromeimpl.object.menu.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import java.util.Optional;

public class MenuListener implements Listener {
    @EventHandler(priority = EventPriority.NORMAL)
    public void onMenuClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;

        InventoryView view = event.getView();
        Inventory topInventory = view.getTopInventory();
        Inventory bottomInventory = view.getBottomInventory();
        Inventory clickedInventory = event.getClickedInventory();

        ItemStack item = event.getCurrentItem();

        InventoryHolder holder = event.getInventory().getHolder();
        if (!(holder instanceof Menu menu)) return;

        event.setCancelled(true);

        if (item == null) return;
        if (clickedInventory == topInventory) {
            menu.handleClick(event);
        } else if (clickedInventory == bottomInventory) {
            menu.handleBottomClick(event);
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onMenuOpen(InventoryOpenEvent event) {
        if (!(event.getPlayer() instanceof Player)) return;

        InventoryHolder holder = event.getView().getTopInventory().getHolder();
        if (!(holder instanceof Menu menu)) return;

        menu.handleOpen(event);
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onMenuClose(InventoryCloseEvent event) {
        if (!(event.getPlayer() instanceof Player)) return;

        InventoryHolder holder = event.getView().getTopInventory().getHolder();
        if (!(holder instanceof Menu menu)) return;

        menu.handleClose(event);
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        Optional<User> optionalUser = AfterRomeAPI.getUser(player);
        if (optionalUser.isEmpty()) return;
        User user = optionalUser.get();

        if (user.getProfession().getName().equalsIgnoreCase("default")) event.setCancelled(true);
    }
}
