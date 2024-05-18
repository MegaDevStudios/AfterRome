package com.megadev.afterrome.object.menu;


import com.megadev.afterrome.object.item.ItemBuilder;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import com.megadev.afterrome.object.user.User;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractUpgradeMenu extends AbstractMenu {
    List<Skill> skills;

    public AbstractUpgradeMenu(User user, List<Skill> skills) {
        super(user, 3);
        this.skills = skills;
    }

    @Override
    public void open() {


        super.open();
    }

    @Override
    protected void setMenuItems() {
        for (int i = 0; i < getSize(); i++) {
            setItem(new MenuItem(new ItemStack(Material.ACACIA_FENCE)), 1);
        }
    }
}
