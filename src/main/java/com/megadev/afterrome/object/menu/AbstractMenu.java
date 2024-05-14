package com.megadev.afterrome.object.menu;

import com.megadev.afterrome.object.shop.skill.Skill;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMenu implements Menu {
    private final Player player;
    private final InventoryType type;
    private final List<Skill> skills = new ArrayList<>();
    private Inventory inventory;

    public AbstractMenu(Player player, int rows) {
        this.player = player;
        this.type = InventoryType.CHEST;
    }

    public AbstractMenu(Player player, InventoryType type) {
        this.player = player;
        this.type = type;
    }
}
