package dev.mega.afterrome.menu;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

import org.bukkit.inventory.InventoryHolder;

public interface Menu extends InventoryHolder {
    String getMenuName();

    void handleClick(InventoryClickEvent event);

    void handleBottomClick(InventoryClickEvent event);

    void handleClose(InventoryCloseEvent event);

    void handleOpen(InventoryOpenEvent event);

    void open();

    void close();
}
