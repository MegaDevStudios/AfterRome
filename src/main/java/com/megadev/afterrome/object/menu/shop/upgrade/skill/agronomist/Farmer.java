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
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.inventory.ItemStack;

@Getter
public class Farmer implements Skill {
    private final MenuItem menuItem;
    private int level = 1;

    public Farmer() {
        ShopManager shopManager = ConfigManager.getInstance().getManager(ShopManager.class);
        menuItem = shopManager.getConfig(AgronomistUpgradeShopConfig.class).getFarmerItem();
    }

    @Override
    public void incrementLevel() {
        level++;
    }

    @Override
    public void execute(Event event) {
        double[] percents = ConfigManager.getInstance().getConfig(AgronomistConfig.class).getFarmerPercents(this.level);
        int countOfFetus = ConditionCalculator.choiceOne(percents);
        BlockDropItemEvent blockDropItemEvent = (BlockDropItemEvent) event;
        User user = UserManager.getInstance().getUser(blockDropItemEvent.getPlayer());

        blockDropItemEvent.setCancelled(true);
        user.addItem(blockDropItemEvent.getItems().get(0).getItemStack(), countOfFetus);
    }
}
