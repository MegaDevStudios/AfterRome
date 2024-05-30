package com.megadev.afterrome.object.menu.shop.upgrade.skill.santa;

import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.config.shop.upgrade.SantaUpgradeShopConfig;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import lombok.Getter;
import org.bukkit.event.Event;

@Getter
public class ForTheWayOfTheSword implements Skill {
    private final MenuItem menuItem;

    public ForTheWayOfTheSword() {
        menuItem = ConfigManager.getInstance().getConfig(SantaUpgradeShopConfig.class).getForTheFaithItem();
    }

    @Override
    public void incrementLevel() {

    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public void execute(Event event) {

    }
}
