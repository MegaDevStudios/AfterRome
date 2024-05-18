package com.megadev.afterrome.object.menu.shop.upgrade.skill.aesculapius;

import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Alchemy implements Skill {
    @Getter
    private final ItemStack item;

    public Alchemy() {
        this.item = new ItemStack(Material.POTION); //todo Пузырек с водой
    }
}
