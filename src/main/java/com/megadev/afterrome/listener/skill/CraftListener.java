package com.megadev.afterrome.listener.skill;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

public class CraftListener implements Listener {
    @EventHandler
    public void onCraft(PrepareItemCraftEvent event){
        if (event.getRecipe() == null) return;
        ItemStack result = event.getRecipe().getResult();

        if (isUncreatedArmor(result.getType())) {

        } else if () {

        }
    }

    private boolean isUncreatedArmor (Material item) {
        return  item == Material.CHAINMAIL_CHESTPLATE ||
                item == Material.DIAMOND_CHESTPLATE ||
                item == Material.IRON_CHESTPLATE ||
                item == Material.GOLDEN_CHESTPLATE ||
                item == Material.CHAINMAIL_HELMET ||
                item == Material.DIAMOND_HELMET ||
                item == Material.IRON_HELMET ||
                item == Material.GOLDEN_HELMET ||
                item == Material.CHAINMAIL_LEGGINGS ||
                item == Material.DIAMOND_LEGGINGS ||
                item == Material.IRON_LEGGINGS ||
                item == Material.GOLDEN_LEGGINGS ||
                item == Material.CHAINMAIL_BOOTS ||
                item == Material.DIAMOND_BOOTS ||
                item == Material.IRON_BOOTS ||
                item == Material.GOLDEN_BOOTS;
    }

    private boolean isUncreatedTool (Material item) {
        return  item == Material.IRON_AXE     ||
                item == Material.IRON_PICKAXE ||
                item == Material.IRON_SHOVEL   ||
                item == Material.IRON_SWORD    ||
                item == Material.IRON_HOE     ||
                item == Material.DIAMOND_HELMET ||
                item == Material.IRON_HELMET ||
                item == Material.GOLDEN_HELMET ||
                item == Material.CHAINMAIL_LEGGINGS ||
                item == Material.DIAMOND_LEGGINGS ||
                item == Material.IRON_LEGGINGS ||
                item == Material.GOLDEN_LEGGINGS ||
                item == Material.CHAINMAIL_BOOTS ||
                item == Material.DIAMOND_BOOTS ||
                item == Material.IRON_BOOTS ||
                item == Material.GOLDEN_BOOTS;
    }
}
