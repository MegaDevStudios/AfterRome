package dev.mega.afterrome.menu.action;

import org.bukkit.event.inventory.InventoryClickEvent;

@FunctionalInterface
public interface ClickAction {
    void execute(InventoryClickEvent event);
}
