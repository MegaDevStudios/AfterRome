package com.megadev.afterrome.object.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public abstract class AbstractItemBuilder<T extends AbstractItemBuilder<T>>  {
    protected final ItemStack itemStack;

    public AbstractItemBuilder(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public AbstractItemBuilder(Material type, int amount) {
        this(new ItemStack(type, amount));
    }

    public AbstractItemBuilder(Material type) {
        this(type, 1);
    }
}
