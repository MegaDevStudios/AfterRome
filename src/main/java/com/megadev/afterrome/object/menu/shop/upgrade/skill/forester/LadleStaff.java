package com.megadev.afterrome.object.menu.shop.upgrade.skill.forester;

import com.megadev.afterrome.config.shop.upgrade.ForesterUpgradeShopConfig;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import lombok.Getter;
import org.bukkit.event.Event;

@Getter
public class LadleStaff implements Skill {
    private final MenuItem menuItem;

    public LadleStaff() {
        menuItem = ConfigManager.getInstance().getConfig(ForesterUpgradeShopConfig.class).getLadleStaffItem();
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
