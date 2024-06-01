package com.megadev.afterrome.object.menu.shop.upgrade.skill.agronomist;

import com.megadev.afterrome.config.manager.ProfessionsManager;
import com.megadev.afterrome.config.manager.ShopManager;
import com.megadev.afterrome.config.profession.AgronomistConfig;
import com.megadev.afterrome.config.shop.upgrade.AgronomistUpgradeShopConfig;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import com.megadev.afterrome.util.ConditionCalculator;
import dev.mega.megacore.MegaCore;
import dev.mega.megacore.util.MegaCoreUtil;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Event;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.util.BoundingBox;

import java.util.Collection;
import java.util.List;

@Getter
public class Hatcher implements Skill {
    private final MenuItem menuItem;
    private int level = 1;

    public Hatcher() {
        ShopManager shopManager = ConfigManager.getInstance().getManager(ShopManager.class);
        menuItem = shopManager.getConfig(AgronomistUpgradeShopConfig.class).getHatcherItem();
    }

    @Override
    public void incrementLevel() {
        level++;
    }

    @Override
    public void execute(Event event) {
        ProfessionsManager professionsManager = ConfigManager.getInstance().getManager(ProfessionsManager.class);
        double percent = professionsManager.getConfig(AgronomistConfig.class).getPercent(this.level, AgronomistConfig.LevelType.CHICKEN);
        int multiplier = ConditionCalculator.isPassed(percent);

        PlayerEggThrowEvent eggThrowEvent = ((PlayerEggThrowEvent) event);

        eggThrowEvent.setHatching(true);
        eggThrowEvent.setNumHatches((byte) multiplier);

    }
}
