package com.megadev.afterrome.listener.skill;

import com.megadev.afterrome.manager.UserManager;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.SkillType;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.agronomist.Lumberjack;
import com.megadev.afterrome.object.profession.Agronomist;
import com.megadev.afterrome.object.profession.Profession;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class BlockListener implements Listener {
    @EventHandler
    public void onDropItem(BlockDropItemEvent event) {
        if (event.getItems().isEmpty()) return;

        Profession profession = UserManager.getInstance().getUser(event.getPlayer()).getProfession();

        if (!(profession instanceof Agronomist)) return;

        if (event.getItems().stream().map(Item::getItemStack).map(ItemStack::getType)
                .anyMatch(type -> type.equals(Material.POTATO) ||
                        type.equals(Material.BEETROOT) ||
                        type.equals(Material.BEETROOT_SEEDS) ||
                        type.equals(Material.CARROT) ||
                        type.equals(Material.CHORUS_FRUIT) ||
                        type.equals(Material.GLOW_BERRIES) ||
                        type.equals(Material.SWEET_BERRIES) ||
                        type.equals(Material.APPLE) ||
                        type.equals(Material.MELON_SLICE) ||
                        type.equals(Material.WHEAT) ||
                        type.equals(Material.WHEAT_SEEDS) ||
                        type.equals(Material.MELON_SEEDS))) {
            profession.getSkill(SkillType.FARMER).execute(event);
        }

    }

    @EventHandler
    public void onWoodBreak(BlockBreakEvent event) {
        Block block = event.getBlock();

        if (block.getType().name().endsWith("LOG")) {
            Profession profession = UserManager.getInstance().getUser(event.getPlayer()).getProfession();
            if (!(profession instanceof Agronomist)) {
                return;
            }

            profession.getSkill(SkillType.LUMBERJACK).execute(event);
        }
    }
}
