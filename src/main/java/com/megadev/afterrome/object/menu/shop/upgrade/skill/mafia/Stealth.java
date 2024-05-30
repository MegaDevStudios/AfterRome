package com.megadev.afterrome.object.menu.shop.upgrade.skill.mafia;

import com.megadev.afterrome.config.shop.upgrade.MafiaUpgradeShopConfig;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import lombok.Getter;
import org.bukkit.event.Event;

@Getter
public class Stealth implements Skill {
    private final MenuItem menuItem;

    public Stealth() {
        menuItem = ConfigManager.getInstance().getConfig(MafiaUpgradeShopConfig.class).getStealthItem();
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
