package com.megadev.afterrome.object.menu.shop.upgrade.skill.agronomist;

import com.megadev.afterrome.config.manager.ShopManager;
import com.megadev.afterrome.config.shop.upgrade.AgronomistUpgradeShopConfig;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import lombok.Getter;
import org.bukkit.event.Event;

@Getter
public class Cook implements Skill {
    private final MenuItem menuItem;
    private int level = 1;

    public Cook() {
        ShopManager shopManager = ConfigManager.getInstance().getManager(ShopManager.class);
        menuItem = shopManager.getConfig(AgronomistUpgradeShopConfig.class).getCookItem();
    }

    @Override
    public void incrementLevel() {
        level++;
    }

    @Override
    public void execute(Event event) {

    }
}
