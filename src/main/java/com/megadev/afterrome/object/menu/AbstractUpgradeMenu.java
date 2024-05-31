package com.megadev.afterrome.object.menu;

import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.object.profession.Profession;
import com.megadev.afterrome.object.user.User;

import dev.mega.megacore.MegaCore;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Random;

public abstract class AbstractUpgradeMenu extends AbstractMenu {
    Profession profession;

    public AbstractUpgradeMenu(User user, Profession profession) {
        super(user, 3);
        this.profession = profession;
    }

    @Override
    public void open() {
        super.open();
    }

    @Override
    protected void setMenuItems() {
        for (int i = 0; i < getSize(); i++)
            setItem(profession.getBackgroundItem(), i);

        int i = 1;
        for (Skill skill : profession.getSkills()) {
            setItem(skill.getMenuItem(), i);
            if (i == 7) i += 12;
            else i += 3;
        }
    }
}
