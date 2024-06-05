package dev.mega.afterromeimpl.object.menu.item;

import dev.mega.afterrome.menu.action.ClickAction;
import dev.mega.afterromeimpl.object.item.AbstractItemBuilder;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class MenuItem extends AbstractItemBuilder<MenuItem> {
    List<ClickAction> actions = new ArrayList<>();

    public MenuItem(ItemStack itemStack) {
        super(itemStack);
    }

    public MenuItem(Material type, int amount) {
        super(type, amount);
    }

    public MenuItem(Material type) {
        super(type);
    }

    public MenuItem addClickAction(ClickAction action) {
        this.actions.add(action);
        return this;
    }

    public MenuItem addShiftClickAction(ClickAction action) {
        this.actions.add((event) -> {
            if (!event.isShiftClick()) return;
            action.execute(event);
        });
        return this;
    }

    public void doClickActions(InventoryClickEvent event) {
        actions.forEach(action -> action.execute(event));
    }

    @Override
    public MenuItem build() {
        return this;
    }
}
