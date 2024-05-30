package com.megadev.afterrome.object.menu.shop.upgrade.skill.agronomist;

import com.megadev.afterrome.config.manager.ShopManager;
import com.megadev.afterrome.config.profession.AgronomistConfig;
import com.megadev.afterrome.config.shop.upgrade.AgronomistUpgradeShopConfig;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import com.megadev.afterrome.util.ConditionCalculator;
import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;

@Getter
public class Farmer implements Skill {
    private final MenuItem menuItem;
    private int level = 1;

    public Farmer() {
        ShopManager shopManager = ConfigManager.getInstance().getManager(ShopManager.class);
        menuItem = shopManager.getConfig(AgronomistUpgradeShopConfig.class).getFarmerItem();
    }

    @Override
    public void incrementLevel() {
        level++;
    }

    @Override
    public void execute(Event event) {
        double[] percents = ConfigManager.getInstance().getConfig(AgronomistConfig.class).getFarmerPercents(this.level);
        int count = ConditionCalculator.isPassed(percents);


    }
}
