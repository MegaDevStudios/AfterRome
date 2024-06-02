package com.megadev.afterrome.object.profession;

import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.config.profession.AgronomistConfig;
import com.megadev.afterrome.config.shop.sale.AgronomistSaleConfig;
import com.megadev.afterrome.config.shop.sale.SaleConfig;
import com.megadev.afterrome.config.shop.upgrade.AgronomistUpgradeShopConfig;
import com.megadev.afterrome.object.menu.AbstractUpgradeMenu;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.menu.AgronomistMenu;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.SkillType;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.agronomist.*;
import com.megadev.afterrome.object.user.User;
import lombok.Getter;

import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.configuration.serialization.SerializableAs;
import org.jetbrains.annotations.NotNull;

import java.util.*;

@Getter
@SerializableAs("agronomist")
public class Agronomist implements Profession {
    List<Skill> skills;

    public Agronomist() {
        skills = List.of(
               new Butcher(1),
               new Cook(1),
               new Farmer(1),
               new Hatcher(1),
               new Lumberjack(1),
               new Tanner(1)
       );
    }

    public Agronomist(Map<String, Object> data) {
        List<Map<String, Object>> mappedSkills = (ArrayList<Map<String, Object>>) data.get("skills"); // List<{level: 0}>
        List<Skill> skillList = List.of(
                new Butcher((Integer) mappedSkills.get(0).get("level")),
                new Cook((Integer) mappedSkills.get(1).get("level")),
                new Farmer((Integer) mappedSkills.get(2).get("level")),
                new Hatcher((Integer) mappedSkills.get(3).get("level")),
                new Lumberjack((Integer) mappedSkills.get(4).get("level")),
                new Tanner((Integer) mappedSkills.get(5).get("level"))
        );

        this.skills = skillList;
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
    public SaleConfig getSaleConfig() {
        return ConfigManager.getInstance().getConfig(AgronomistSaleConfig.class);
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
        Map<String, Object> skills = Map.of(
                "butcher", getSkill(SkillType.BUTCHER).serialize(), // "butcher" -> {"level": 0}
                "cook", getSkill(SkillType.COOK).serialize(),
                "farmer", getSkill(SkillType.FARMER).serialize(),
                "hatcher", getSkill(SkillType.HATCHER).serialize(),
                "lumberjack", getSkill(SkillType.LUMBERJACK).serialize(),
                "tanner", getSkill(SkillType.TANNER).serialize()
        );

        return Map.of("skills", skills);
    }

    @Override
    public Profession deserialize(Map<String, Object> data) {
        return new Agronomist(data);
    }

    static {
        ConfigurationSerialization.registerClass(Agronomist.class); // (Profession) config.get("key")
    }
}
