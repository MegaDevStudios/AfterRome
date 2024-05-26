package com.megadev.afterrome.object.menu.shop.upgrade.menu;

import com.megadev.afterrome.object.menu.AbstractUpgradeMenu;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.object.user.User;
import org.bukkit.Material;

import java.util.List;

public class AesculapiusMenu extends AbstractUpgradeMenu {
    public AesculapiusMenu(User user, List<Skill> skills) {
        super(user, skills);
    }

    @Override
    protected void setMenuItems() {
        super.setMenuItems();
        setItem(new MenuItem(Material.DIORITE_STAIRS), 3);
    }

    @Override
    public String getMenuName() {
        return "Меню эскулапа";
    }
}
