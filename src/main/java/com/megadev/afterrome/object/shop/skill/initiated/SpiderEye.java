package com.megadev.afterrome.object.shop.skill.initiated;

import com.megadev.afterrome.object.ShopItem;
import com.megadev.afterrome.object.shop.skill.Skill;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;

public class SpiderEye implements Skill, ShopItem {
    @Getter
    private ItemStack item;
}
