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

    public Cook() {
        ShopManager shopManager = ConfigManager.getInstance().getManager(ShopManager.class);
        menuItem = shopManager.getConfig(AgronomistUpgradeShopConfig.class).getCookItem();
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
