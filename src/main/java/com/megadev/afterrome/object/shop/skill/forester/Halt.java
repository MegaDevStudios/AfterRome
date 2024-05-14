package com.megadev.afterrome.object.shop.skill.forester;

import com.megadev.afterrome.object.ShopItem;
import com.megadev.afterrome.object.shop.skill.Skill;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;

public class Halt implements Skill, ShopItem {
    @Getter
    private ItemStack item;
}
