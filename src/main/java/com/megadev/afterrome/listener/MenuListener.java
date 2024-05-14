package com.megadev.afterrome.listener;

import com.megadev.afterrome.object.menu.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class MenuListener implements Listener {
    @EventHandler(priority = EventPriority.NORMAL)
    public void onMenuClick(InventoryClickEvent event)
    {
        if (!(event.getWhoClicked() instanceof Player)) return;

        Inventory inventory = event.getView().getTopInventory();
        ItemStack item = event.getCurrentItem();

        InventoryHolder holder = event.getInventory().getHolder();
        if (!(holder instanceof Menu menu)) return;

        event.setCancelled(true);

        if (item == null) return;
        if (event.getClickedInventory() != inventory) return;

        menu.handleMenu(event);
    }
}
