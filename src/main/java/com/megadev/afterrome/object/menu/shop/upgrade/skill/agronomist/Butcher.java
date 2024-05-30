package com.megadev.afterrome.object.menu.shop.upgrade.skill.agronomist;

import com.megadev.afterrome.config.manager.ShopManager;
import com.megadev.afterrome.config.profession.AgronomistConfig;
import com.megadev.afterrome.config.shop.upgrade.AgronomistUpgradeShopConfig;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.manager.UserManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import com.megadev.afterrome.object.user.User;
import com.megadev.afterrome.util.ConditionCalculator;
import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityDropItemEvent;

@Getter
public class Butcher implements Skill {
    private final MenuItem menuItem;
    private int level = 1;

    public Butcher() {
        ShopManager shopManager = ConfigManager.getInstance().getManager(ShopManager.class);
        menuItem = shopManager.getConfig(AgronomistUpgradeShopConfig.class).getButcherItem();
    }

    @Override
    public void incrementLevel() {
        level++;
    }

    @Override
    public void execute(Event event) {
        double[] percents = ConfigManager.getInstance().getConfig(AgronomistConfig.class).getButcherPercents(this.level);
        int countOfMeat = ConditionCalculator.choiceOne(percents);
        EntityDeathEvent entityDeathEvent = (EntityDeathEvent) event;
        User user = UserManager.getInstance().getUser(entityDeathEvent.getEntity().getKiller());

        entityDeathEvent.setCancelled(true);
        user.addItem(entityDeathEvent.getDrops().get(0), countOfMeat);
    }
}
