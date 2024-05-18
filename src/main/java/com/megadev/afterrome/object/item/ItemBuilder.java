package com.megadev.afterrome.object.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemBuilder extends AbstractItemBuilder<ItemBuilder>{
    public ItemBuilder(ItemStack itemStack) {
        super(itemStack);
    }

    public ItemBuilder(Material type, int amount) {
        super(type, amount);
    }

    public ItemBuilder(Material type) {
        super(type);
    }

    @Override
    public ItemBuilder getThis() {
        return this;
    }

    @Override
    public ItemBuilder clone() {
        return new ItemBuilder(itemStack.clone());
    }
}
