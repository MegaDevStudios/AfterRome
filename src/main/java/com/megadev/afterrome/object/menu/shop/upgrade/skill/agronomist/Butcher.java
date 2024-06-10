package com.megadev.afterrome.object.menu.shop.upgrade.skill.agronomist;

import com.megadev.afterrome.config.profession.AgronomistConfig;
import com.megadev.afterrome.config.profession.ProfessionConfig;
import com.megadev.afterrome.config.shop.upgrade.AgronomistUpgradeShopConfig;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import com.megadev.afterrome.object.menu.shop.upgrade.skill.SkillType;
import com.megadev.afterrome.util.ConditionCalculator;
import lombok.Getter;

import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.configuration.serialization.SerializableAs;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

@Getter
@SerializableAs("butcher")
public class Butcher implements Skill {
    private final MenuItem menuItem = ConfigManager.getInstance().getConfig(AgronomistUpgradeShopConfig.class).getButcherItem();
    @Setter
    private int level;

    public Butcher(int level) {
        this.level = level;
    }

    @Override
    public String getName() {
        return ConfigManager.getInstance().getConfig(AgronomistUpgradeShopConfig.class).getButcherName();
    }

    @Override
    public SkillType getSkillType() {
        return SkillType.BUTCHER;
    }

    @Override
    public void execute(Event event) {
        double[] percents = ConfigManager.getInstance().getConfig(AgronomistConfig.class)
                .getPercents(this.level, ProfessionConfig.LevelType.MEAT);
        int countOfMeat = ConditionCalculator.choiceOne(percents);
        EntityDeathEvent entityDeathEvent = (EntityDeathEvent) event;

        List<ItemStack> items = entityDeathEvent.getDrops();

        for (ItemStack item : items) {
            if (isMeat(item.getType())) {
                item.setAmount(countOfMeat);
            }
        }
    }

    private boolean isMeat(Material material) {
        return  material == Material.BEEF ||
                material == Material.RABBIT ||
                material == Material.CHICKEN ||
                material == Material.PORKCHOP ||
                material == Material.MUTTON;
    }

    static {
        ConfigurationSerialization.registerClass(Butcher.class);
    }
}
