package com.megadev.afterrome.object.shop.skill.sonofmars;

import com.megadev.afterrome.object.ShopItem;
import com.megadev.afterrome.object.shop.skill.Skill;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;

public class IronOutside implements Skill, ShopItem {
    @Getter
    private ItemStack item;
}
