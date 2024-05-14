package com.megadev.afterrome.object.shop.menu;

import com.megadev.afterrome.object.menu.UpgradeMenu;
import com.megadev.afterrome.object.shop.skill.Skill;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ArtisanMenu implements UpgradeMenu {
    List<Skill> skills = new ArrayList<>();
    private final InventoryType type;
    private Inventory inventory;




    @Override
    public void handleMenu(InventoryClickEvent event) {

    }

    @NotNull
    @Override
    public Inventory getInventory() {
        return null;
    }
}
