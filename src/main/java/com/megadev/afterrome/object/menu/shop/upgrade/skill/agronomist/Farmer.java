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
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

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
        ProfessionsManager professionsManager = ConfigManager.getInstance().getManager(ProfessionsManager.class);
        double[] percents = professionsManager.getConfig(AgronomistConfig.class)
                .getPercents(this.level, AgronomistConfig.LevelType.FETUS);
        int countOfFetus = ConditionCalculator.choiceOne(percents);
        BlockDropItemEvent blockDropItemEvent = (BlockDropItemEvent) event;
        Player player = blockDropItemEvent.getPlayer();

        List<Item> items = blockDropItemEvent.getItems();
        Item item = items.get(0);
        Material itemType = items.get(0).getItemStack().getType();

        if (items.size() == 1 &&
                (itemType.equals(Material.MELON_SEEDS) ||
                itemType.equals(Material.WHEAT_SEEDS) ||
                itemType.equals(Material.PUMPKIN_SEEDS) ||
                itemType.equals(Material.TORCHFLOWER_SEEDS) ||
                (itemType.equals(Material.POTATO) && items.get(0).getItemStack().getAmount() < 2) ||
                (itemType.equals(Material.CARROT) && items.get(0).getItemStack().getAmount() < 2))) {
            items = List.of(item);
            return;
        }

        items.add(player.getWorld().dropItem(blockDropItemEvent.getBlock().getLocation().add(0, 1, 0), item.getItemStack().add(countOfFetus)));
    }
}
