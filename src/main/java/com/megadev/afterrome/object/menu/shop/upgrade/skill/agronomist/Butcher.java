package com.megadev.afterrome.object.menu.shop.upgrade.skill.agronomist;

import com.megadev.afterrome.config.manager.ProfessionsManager;
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
import org.bukkit.entity.*;
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
        ProfessionsManager professionsManager = ConfigManager.getInstance().getManager(ProfessionsManager.class);
        double[] percents = professionsManager.getConfig(AgronomistConfig.class)
                .getPercents(this.level, AgronomistConfig.LevelType.MEAT);
        int countOfMeat = ConditionCalculator.choiceOne(percents);
        EntityDeathEvent entityDeathEvent = (EntityDeathEvent) event;
        User user = UserManager.getInstance().getUser(entityDeathEvent.getEntity().getKiller());

        LivingEntity entity = entityDeathEvent.getEntity();

        if (entity instanceof Cow) {
            user.addItem(entityDeathEvent.getDrops().get(0), countOfMeat);
        } else if (entity instanceof Rabbit) {
            user.addItem(entityDeathEvent.getDrops().get(0), countOfMeat);
        } else if (entity instanceof Pig) {
            user.addItem(entityDeathEvent.getDrops().get(0), countOfMeat);
        } else if (entity instanceof Sheep) {
            user.addItem(entityDeathEvent.getDrops().get(0), countOfMeat);
        }
    }
}
