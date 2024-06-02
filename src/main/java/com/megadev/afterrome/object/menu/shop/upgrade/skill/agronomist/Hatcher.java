package com.megadev.afterrome.object.menu.shop.upgrade.skill.agronomist;

import com.megadev.afterrome.config.profession.AgronomistConfig;
import com.megadev.afterrome.config.shop.upgrade.AgronomistUpgradeShopConfig;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import com.megadev.afterrome.util.ConditionCalculator;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

@Getter
public class Hatcher implements Skill {
    private final MenuItem menuItem;
    private int level = 1;

    public Hatcher() {
        menuItem = ConfigManager.getInstance().getConfig(AgronomistUpgradeShopConfig.class).getHatcherItem();
    }

    @Override
    public void incrementLevel() {
        level++;
    }

    @Override
    public void execute(Event event) {
        double percent = ConfigManager.getInstance().getConfig(AgronomistConfig.class).getPercent(this.level, AgronomistConfig.LevelType.CHICKEN);
        int multiplier = ConditionCalculator.isPassed(percent);

        PlayerEggThrowEvent eggThrowEvent = ((PlayerEggThrowEvent) event);

        eggThrowEvent.setHatching(true);
        eggThrowEvent.setNumHatches((byte) multiplier);

        Bukkit.broadcastMessage("[DEBUG] Multiplier of eggs " + multiplier);
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        return Map.of();
    }
}
