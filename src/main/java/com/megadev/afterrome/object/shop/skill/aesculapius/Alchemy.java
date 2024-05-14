package com.megadev.afterrome.object.shop.skill.aesculapius;

import com.megadev.afterrome.object.shop.skill.Skill;
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
