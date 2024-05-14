package com.megadev.afterrome.object.shop.skill.agronomist;

import com.megadev.afterrome.object.ShopItem;
import com.megadev.afterrome.object.shop.skill.Skill;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;

public class Hatcher implements Skill, ShopItem {
    @Getter
    private ItemStack item;
}
