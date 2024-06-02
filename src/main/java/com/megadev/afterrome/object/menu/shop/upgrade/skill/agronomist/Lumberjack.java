package com.megadev.afterrome.object.menu.shop.upgrade.skill.agronomist;

import com.megadev.afterrome.config.profession.AgronomistConfig;
import com.megadev.afterrome.config.shop.upgrade.AgronomistUpgradeShopConfig;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.manager.ability.TreecapitatorManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import com.megadev.afterrome.util.ConditionCalculator;
import lombok.Getter;
import org.bukkit.block.Block;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

@Getter
public class Lumberjack implements Skill {
    private final MenuItem menuItem;
    private int level = 1;

    public Lumberjack() {
        menuItem = ConfigManager.getInstance().getConfig(AgronomistUpgradeShopConfig.class).getLumberjackItem();
    }

    @Override
    public void incrementLevel() {
        level++;
    }

    @Override
    public void execute(Event event) {
        double percent = ConfigManager.getInstance().getConfig(AgronomistConfig.class).getPercent(this.level, AgronomistConfig.LevelType.LUMBERJACK);

        BlockBreakEvent breakEvent = (BlockBreakEvent) event;

        Block block = breakEvent.getBlock();

        if (ConditionCalculator.isPassed(percent) == 1) {
            TreecapitatorManager.getInstance().treeCapitate(block);
        }
    }
}
