package dev.mega.afterrome.config.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ShopMenuSection {
    private final int rows;
    private final String MenuName;
    private final List<MenuItemSection> items;
    private final HashMap<ItemStack, Integer> sellItems;
}
