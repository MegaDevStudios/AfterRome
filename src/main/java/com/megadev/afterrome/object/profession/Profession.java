package com.megadev.afterrome.object.profession;

import com.megadev.afterrome.config.shop.sale.SaleConfig;
import com.megadev.afterrome.object.menu. AbstractUpgradeMenu;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.SkillType;
import com.megadev.afterrome.object.user.User;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;

import java.util.List;
import java.util.Map;

@SerializableAs("profession")
public interface Profession extends ConfigurationSerializable {
    String getName();

    ProfessionType getProfessionType();

    AbstractUpgradeMenu getUpgradeMenu(User user);

    MenuItem getBackgroundItem();

    List<Skill> getSkills();

    Skill getSkill(SkillType skill);

    Profession deserialize(Map<String, Object> data);

    SaleConfig getSaleConfig();
}
