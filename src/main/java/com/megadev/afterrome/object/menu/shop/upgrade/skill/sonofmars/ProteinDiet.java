package com.megadev.afterrome.object.menu.shop.upgrade.skill.sonofmars;

import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.config.shop.upgrade.SonOfMarsUpgradeShopConfig;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import lombok.Getter;
import org.bukkit.event.Event;

@Getter
public class ProteinDiet implements Skill {
    private final MenuItem menuItem;

    public ProteinDiet() {
        menuItem = ConfigManager.getInstance().getConfig(SonOfMarsUpgradeShopConfig.class).getProteinDietItem();
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
