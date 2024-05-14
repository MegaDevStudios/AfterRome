package com.megadev.afterrome.object.shop.menu;

import com.megadev.afterrome.object.menu.AbstractUpgradeMenu;
import com.megadev.afterrome.object.shop.skill.Skill;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AesculapiusMenu {
    List<Skill> skills = new ArrayList<>();

    public void handleMenu(InventoryClickEvent event) {

    }

    @NotNull
    public Inventory getInventory() {
        return null;
    }
}
