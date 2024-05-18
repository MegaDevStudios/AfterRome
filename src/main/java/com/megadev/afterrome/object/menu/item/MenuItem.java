package com.megadev.afterrome.object.menu.item;

import com.megadev.afterrome.object.item.AbstractItemBuilder;
import com.megadev.afterrome.object.menu.action.ClickAction;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class MenuItem extends AbstractItemBuilder<MenuItem> {
    private final List<ClickAction> clickActions = new ArrayList<>();

    public MenuItem(ItemStack itemStack) {
        super(itemStack);
    }

    public MenuItem(Material type, int amount) {
        super(type, amount);
    }

    public MenuItem(Material type) {
        super(type);
    }

    @Override
    public MenuItem getThis() {
        return this;
    }

    @Override
    public MenuItem clone() {
        return new MenuItem(itemStack.clone());
    }

    public void doClickActions(InventoryClickEvent event) {
        clickActions.forEach(action -> action.execute(event));
    }
}
