package com.megadev.afterrome.object.menu.shop.upgrade.skill.agronomist;

import com.megadev.afterrome.config.manager.ProfessionsManager;
import com.megadev.afterrome.config.manager.ShopManager;
import com.megadev.afterrome.config.profession.AgronomistConfig;
import com.megadev.afterrome.config.shop.upgrade.AgronomistUpgradeShopConfig;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import com.megadev.afterrome.util.ConditionCalculator;
import com.megadev.afterrome.util.TreeCapitator;
import lombok.Getter;
import org.bukkit.block.Block;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;

@Getter
public class Lumberjack implements Skill {
    private final MenuItem menuItem;
    private int level = 1;

    public Lumberjack() {
        ShopManager shopManager = ConfigManager.getInstance().getManager(ShopManager.class);
        menuItem = shopManager.getConfig(AgronomistUpgradeShopConfig.class).getLumberjackItem();
    }

    @Override
    public void incrementLevel() {
        level++;
    }

    @Override
    public void execute(Event event) {
        ProfessionsManager professionsManager = ConfigManager.getInstance().getManager(ProfessionsManager.class);
        double percent = professionsManager.getConfig(AgronomistConfig.class).getPercent(this.level, AgronomistConfig.LevelType.LUMBERJACK);

        BlockBreakEvent breakEvent = (BlockBreakEvent) event;

        Block block = breakEvent.getBlock();

        if (ConditionCalculator.isPassed(percent) == 1) {
            TreeCapitator treeCapitator = new TreeCapitator(block.getLocation(), block.getType());
            treeCapitator.treeCapitate();
        }
    }
}
