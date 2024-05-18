package com.megadev.afterrome.object.menu.shop.upgrade.menu;

import com.megadev.afterrome.object.menu.AbstractUpgradeMenu;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import com.megadev.afterrome.object.user.User;
import org.bukkit.inventory.Inventory;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ArtisanMenu extends AbstractUpgradeMenu {
    public ArtisanMenu(User user, List<Skill> skills) {
        super(user, skills);
    }

    @Override
    protected void setMenuItems() {

    }

    @Override
    public String getMenuName() {
        return "";
    }
}
