package com.megadev.afterrome.listener;

import com.megadev.afterrome.manager.MenuManager;
import com.megadev.afterrome.manager.UserManager;
import com.megadev.afterrome.object.menu.Menu;
import com.megadev.afterrome.object.profession.Agronomist;
import com.megadev.afterrome.object.profession.DefaultProfession;
import com.megadev.afterrome.object.user.User;

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
import org.bukkit.inventory.ItemStack;

import java.util.Optional;

public class MenuListener implements Listener {
    @EventHandler(priority = EventPriority.NORMAL)
    public void onMenuClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;

        Inventory inventory = event.getView().getTopInventory();
        ItemStack item = event.getCurrentItem();

        InventoryHolder holder = event.getInventory().getHolder();
        if (!(holder instanceof Menu menu)) return;

        event.setCancelled(true);

        if (item == null) return;
        if (event.getClickedInventory() != inventory) return;

        menu.handleClick(event);
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onMenuOpen(InventoryOpenEvent event)
    {
        if (!(event.getPlayer() instanceof Player)) return;

        InventoryHolder holder = event.getView().getTopInventory().getHolder();
        if (!(holder instanceof Menu menu)) return;

        menu.handleOpen(event);
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onMenuClose(InventoryCloseEvent event)
    {
        if (!(event.getPlayer() instanceof Player player)) return;

        InventoryHolder holder = event.getView().getTopInventory().getHolder();
        if (!(holder instanceof Menu menu)) return;

        menu.handleClose(event);

        User user = UserManager.getInstance().getUser(player);
        if (user != null) {
            if (MenuManager.getInstance().getRefreshingMenus().containsKey(user)) {
                MenuManager.getRefreshingMenus().get(user).cancel();
                MenuManager.getRefreshingMenus().remove(user);
            }
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        User user = UserManager.getInstance().getUser(player);
        if (user == null) return;

        if (user.getProfession() instanceof DefaultProfession) event.setCancelled(true);
    }
}
