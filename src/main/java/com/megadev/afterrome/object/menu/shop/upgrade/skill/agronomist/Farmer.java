package com.megadev.afterrome.object.menu.shop.upgrade.skill.agronomist;

import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import com.megadev.afterrome.object.menu.shop.upgrade.skill.SkillType;
import lombok.Getter;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.configuration.serialization.SerializableAs;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

@Getter
@SerializableAs("farmer")
public class Farmer implements Skill, ConfigurationSerializable {
    private final MenuItem menuItem = null;
    private int level;

    public Farmer(int level) {
        this.level = level;
    }

    @Override
    public String getName() {
        return "farmer";
    }

    @Override
    public SkillType getSkillType() {
        return SkillType.FARMER;
    }

    @Override
    public void incrementLevel() {
        level++;
    }

    @Override
    public void execute(Event event) {
//        double[] percents = ConfigManager.getInstance().getConfig(AgronomistConfig.class)
//                .getPercents(this.level, AgronomistConfig.LevelType.FETUS);
//        int countOfFetus = ConditionCalculator.choiceOne(percents);
//        BlockDropItemEvent blockDropItemEvent = (BlockDropItemEvent) event;
//        Player player = blockDropItemEvent.getPlayer();
//
//        List<Item> items = blockDropItemEvent.getItems();
//        Item item = items.get(0);
//        Material itemType = items.get(0).getItemStack().getType();
//
//        if (items.size() == 1 &&
//                (itemType.equals(Material.MELON_SEEDS) ||
//                itemType.equals(Material.WHEAT_SEEDS) ||
//                itemType.equals(Material.PUMPKIN_SEEDS) ||
//                itemType.equals(Material.TORCHFLOWER_SEEDS) ||
//                (itemType.equals(Material.POTATO) && items.get(0).getItemStack().getAmount() < 2) ||
//                (itemType.equals(Material.CARROT) && items.get(0).getItemStack().getAmount() < 2))) {
//            items = List.of(item);
//            return;
//        }
//        MegaCoreUtil.getLogger().info("Count of fetus added " + countOfFetus);
//        player.sendMessage("[DEBUG] Count of fetus added " + countOfFetus);
//        items.add(player.getWorld().dropItem(blockDropItemEvent.getBlock().getLocation().add(0, 1, 0), item.getItemStack().add(countOfFetus)));
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        return Skill.super.serialize();
    }

    static {
        ConfigurationSerialization.registerClass(Farmer.class);
    }
}
