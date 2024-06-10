package com.megadev.afterrome.object.menu.shop.upgrade.skill.agronomist;

import com.megadev.afterrome.config.profession.AgronomistConfig;
import com.megadev.afterrome.config.profession.ProfessionConfig;
import com.megadev.afterrome.config.shop.upgrade.AgronomistUpgradeShopConfig;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.manager.TreecapitatorManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import com.megadev.afterrome.object.menu.shop.upgrade.skill.SkillType;
import com.megadev.afterrome.util.ConditionCalculator;
import dev.mega.megacore.manager.MegaManager;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.block.Block;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.configuration.serialization.SerializableAs;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;

@Getter
@SerializableAs("lumberjack")
public class Lumberjack implements Skill {
    private final MenuItem menuItem = ConfigManager.getInstance().getConfig(AgronomistUpgradeShopConfig.class).getLumberjackItem();
    @Setter
    private int level;

    public Lumberjack(int level) {
        this.level = level;
    }

    @Override
    public String getName() {
        return ConfigManager.getInstance().getConfig(AgronomistUpgradeShopConfig.class).getLumberjackName();
    }

    @Override
    public SkillType getSkillType() {
        return SkillType.LUMBERJACK;
    }

    @Override
    public void execute(Event event) {
        double percent = ConfigManager.getInstance().getConfig(AgronomistConfig.class)
                .getPercent(this.level, ProfessionConfig.LevelType.LUMBERJACK);

        BlockBreakEvent breakEvent = (BlockBreakEvent) event;

        Block block = breakEvent.getBlock();

        if (ConditionCalculator.isPassed(percent) == 1) {
            MegaManager.getManager(TreecapitatorManager.class).treeCapitate(block);
        }
    }

    static {
        ConfigurationSerialization.registerClass(Lumberjack.class);
    }
}
