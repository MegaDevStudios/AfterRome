package com.megadev.afterrome.object.menu.shop.upgrade.skill.agronomist;

import com.megadev.afterrome.config.manager.ProfessionsManager;
import com.megadev.afterrome.config.manager.ShopManager;
import com.megadev.afterrome.config.profession.AgronomistConfig;
import com.megadev.afterrome.config.shop.upgrade.AgronomistUpgradeShopConfig;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import com.megadev.afterrome.util.ConditionCalculator;
import lombok.Getter;

import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

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

        List<ItemStack> items = entityDeathEvent.getDrops();

        if (items.size() == 1 && (items.get(0).getType() == Material.BEEF ||
                items.get(0).getType() == Material.RABBIT ||
                items.get(0).getType() == Material.CHICKEN ||
                items.get(0).getType() == Material.PORKCHOP ||
                items.get(0).getType() == Material.MUTTON)) {
            items.get(0).setAmount(countOfMeat);
        } else if (items.size() == 2 && (items.get(1).getType() == Material.BEEF ||
                items.get(1).getType() == Material.RABBIT ||
                items.get(1).getType() == Material.CHICKEN ||
                items.get(1).getType() == Material.PORKCHOP ||
                items.get(1).getType() == Material.MUTTON)) {
            items.get(1).setAmount(countOfMeat);
        }

    }
}
