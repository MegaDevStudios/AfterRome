package com.megadev.afterrome.object.menu.shop.upgrade.skill.agronomist;

import com.megadev.afterrome.config.profession.AgronomistConfig;
import com.megadev.afterrome.config.profession.ProfessionConfig;
import com.megadev.afterrome.config.shop.upgrade.AgronomistUpgradeShopConfig;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import com.megadev.afterrome.object.menu.shop.upgrade.skill.SkillType;
import com.megadev.afterrome.util.ConditionCalculator;
import lombok.Getter;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.configuration.serialization.SerializableAs;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

@Getter
@SerializableAs("butcher")
public class Butcher implements Skill, ConfigurationSerializable {
    private final MenuItem menuItem = null;
    private int level;

    public Butcher(int level) {
        this.level = level;
    }

    @Override
    public String getName() {
        return "butcher";
    }

    @Override
    public SkillType getSkillType() {
        return SkillType.BUTCHER;
    }

    @Override
    public void incrementLevel() {
        level++;
    }

    @Override
    public void execute(Event event) {
//        double[] percents = ConfigManager.getInstance().getConfig(AgronomistConfig.class)
//                .getPercents(this.level, ProfessionConfig..MEAT);
//        int countOfMeat = ConditionCalculator.choiceOne(percents);
//        EntityDeathEvent entityDeathEvent = (EntityDeathEvent) event;
//
//        List<ItemStack> items = entityDeathEvent.getDrops();
//
//        if (items.size() == 1 && (items.get(0).getType() == Material.BEEF ||
//                items.get(0).getType() == Material.RABBIT ||
//                items.get(0).getType() == Material.CHICKEN ||
//                items.get(0).getType() == Material.PORKCHOP ||
//                items.get(0).getType() == Material.MUTTON)) {
//            items.get(0).setAmount(countOfMeat);
//        } else if (items.size() == 2 && (items.get(1).getType() == Material.BEEF ||
//                items.get(1).getType() == Material.RABBIT ||
//                items.get(1).getType() == Material.CHICKEN ||
//                items.get(1).getType() == Material.PORKCHOP ||
//                items.get(1).getType() == Material.MUTTON)) {
//            items.get(1).setAmount(countOfMeat);
//        }
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        return Skill.super.serialize();
    }

    static {
        ConfigurationSerialization.registerClass(Butcher.class);
    }
}
