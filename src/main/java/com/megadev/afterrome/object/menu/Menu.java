package com.megadev.afterrome.object.menu;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;

public interface Menu extends InventoryHolder {
    void handleMenu(InventoryClickEvent event);
}
