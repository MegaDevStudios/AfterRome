package com.megadev.afterrome.object.menu.shop.upgrade.skill.agronomist;

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
public class Tanner implements Skill {
    private final MenuItem menuItem;
    private int level = 1;

    public Tanner() {
        menuItem = ConfigManager.getInstance().getConfig(AgronomistUpgradeShopConfig.class).getTannerItem();
    }

    @Override
    public void incrementLevel() {
        level++;
    }

    @Override
    public void execute(Event event) {
        double[] percents = ConfigManager.getInstance().getConfig(AgronomistConfig.class).getPercents(this.level, AgronomistConfig.LevelType.LEATHER);
        int countOfLeather = ConditionCalculator.choiceOne(percents);

        EntityDeathEvent entityDeathEvent = (EntityDeathEvent) event;

        List<ItemStack> items = entityDeathEvent.getDrops();

        if (items.stream().map(ItemStack::getType).toList().contains(Material.LEATHER)) {
            items.stream().filter(item -> item.getType() == Material.LEATHER).forEach(itemStack -> itemStack.setAmount(countOfLeather));
        }
    }
}
