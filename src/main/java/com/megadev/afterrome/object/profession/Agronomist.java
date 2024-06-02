package com.megadev.afterrome.object.profession;

import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.config.profession.AgronomistConfig;
import com.megadev.afterrome.config.shop.upgrade.AgronomistUpgradeShopConfig;
import com.megadev.afterrome.object.menu.AbstractUpgradeMenu;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.menu.AgronomistMenu;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.SkillType;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.agronomist.*;
import com.megadev.afterrome.object.user.AfterRomeUser;
import com.megadev.afterrome.object.user.User;
import dev.mega.megacore.MegaCore;
import lombok.Getter;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

@Getter
public class Agronomist implements Profession {
    List<Skill> skills;

    public Agronomist() {
        skills = List.of(
               new Butcher(),
               new Cook(),
               new Farmer(),
               new Hatcher(),
               new Lumberjack(),
               new Tanner()
       );
    }

    public Agronomist(Map<String, Object> data) {
        this.skills = (List<Skill>) data.get("skills");
    }

    @Override
    public Skill getSkill(SkillType agronomistSkill) {
        return switch (agronomistSkill) {
            case BUTCHER -> skills.get(0);
            case COOK -> skills.get(1);
            case FARMER -> skills.get(2);
            case HATCHER -> skills.get(3);
            case LUMBERJACK -> skills.get(4);
            case TANNER -> skills.get(5);
        };
    }

    @Override
    public String getName() {
        return ConfigManager.getInstance().getConfig(AgronomistConfig.class).getName();
    }

    @Override
    public AbstractUpgradeMenu getUpgradeMenu(User user) {
        return new AgronomistMenu(user, this);
    }

    @Override
    public MenuItem getBackgroundItem() {
        return ConfigManager.getInstance().getConfig(AgronomistUpgradeShopConfig.class).getBackgroundItem();
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        return Map.of("skills", skills.stream().map(ConfigurationSerializable::serialize));
    }

    @Override
    public Profession deserialize(Map<String, Object> data) {
        return new Agronomist(data);
    }

    static {
        ConfigurationSerialization.registerClass(Agronomist.class);
    }
}
