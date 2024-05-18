package com.megadev.afterrome.object.menu.shop.upgrade.menu;

import com.megadev.afterrome.object.menu.AbstractUpgradeMenu;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import com.megadev.afterrome.object.user.User;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AesculapiusMenu extends AbstractUpgradeMenu {
    List<Skill> skills = new ArrayList<>();

    public AesculapiusMenu(User user, Skill skill) {
        super(user, skill);
    }

    public void handleMenu(InventoryClickEvent event) {

    }

    @NotNull
    public Inventory getInventory() {
        return null;
    }

    @Override
    protected void setMenuItems() {

    }

    @Override
    public String getMenuName() {
        return "";
    }
}
