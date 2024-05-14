package com.megadev.afterrome.object.shop.skill.aesculapius;

import com.megadev.afterrome.object.shop.skill.Skill;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@Getter
public class BrutalSurgery implements Skill {
    private final ItemStack item;

    public BrutalSurgery() {
        this.item = new ItemStack(Material.POTION);
    }
}
