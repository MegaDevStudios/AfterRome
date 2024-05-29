package com.megadev.afterrome.object.profession;

import com.megadev.afterrome.object.menu. AbstractUpgradeMenu;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.object.user.User;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.List;

public interface Profession extends ConfigurationSerializable {
    String getNameOfProfession();

    AbstractUpgradeMenu getUpgradeMenu(User user);

    MenuItem getBackgroundItem();

    List<Skill> getSkills();
}
