package com.megadev.afterrome.object.menu;


import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;

public abstract class AbstractUpgradeMenu extends AbstractMenu implements UpgradeMenu {

    public AbstractUpgradeMenu(Player player, int rows) {
        super(player, rows);
    }

    public AbstractUpgradeMenu(Player player, InventoryType type) {
        super(player, type);
    }
}
