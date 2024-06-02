package com.megadev.afterrome.object.menu.shop.upgrade.skill.agronomist;

import com.megadev.afterrome.config.profession.AgronomistConfig;
import com.megadev.afterrome.config.shop.upgrade.AgronomistUpgradeShopConfig;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import com.megadev.afterrome.object.user.AfterRomeUser;
import com.megadev.afterrome.util.ConditionCalculator;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.configuration.serialization.SerializableAs;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

@Getter
@SerializableAs("tanner")
public class Tanner implements Skill {
    private final MenuItem menuItem = ConfigManager.getInstance().getConfig(AgronomistUpgradeShopConfig.class).getTannerItem();
    private int level;

    public Tanner(int level) {
        this.level = level;
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

    static {
        ConfigurationSerialization.registerClass(Tanner.class);
    }
}
