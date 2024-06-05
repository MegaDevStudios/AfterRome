package com.megadev.afterrome.object.menu.shop.upgrade.skill.agronomist;

import com.megadev.afterrome.config.shop.upgrade.AgronomistUpgradeShopConfig;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import com.megadev.afterrome.object.menu.shop.upgrade.skill.SkillType;
import lombok.Getter;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.configuration.serialization.SerializableAs;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

@Getter
@SerializableAs("cook")
public class Cook implements Skill, ConfigurationSerializable {
    private final MenuItem menuItem = ConfigManager.getInstance().getConfig(AgronomistUpgradeShopConfig.class).getCookItem();
    private int level;

    public Cook(int level) {
        this.level = level;
    }

    @Override
    public String getName() {
        return "cook";
    }

    @Override
    public SkillType getSkillType() {
        return SkillType.COOK;
    }

    @Override
    public void incrementLevel() {
        level++;
    }

    @Override
    public void execute(Event event) {

    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        return Skill.super.serialize();
    }

    static {
        ConfigurationSerialization.registerClass(Cook.class);
    }
}
