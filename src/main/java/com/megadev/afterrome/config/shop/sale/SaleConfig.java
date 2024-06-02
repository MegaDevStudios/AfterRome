package com.megadev.afterrome.config.shop.sale;

import com.megadev.afterrome.object.item.ItemBuilder;
import dev.mega.megacore.config.Configurator;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Set;

public abstract class SaleConfig extends Configurator {
    protected SaleConfig(@NotNull Plugin plugin, String... path) {
        super(plugin, path);
    }

    public HashMap<ItemStack, Integer> getSaleItems() {
        HashMap<ItemStack, Integer> itemStacks = new HashMap<>();
        ConfigurationSection sellItemsSection = config.getConfigurationSection("sell-items");

        if (sellItemsSection == null) return new HashMap<>();

        Set<String> keysSellItems = sellItemsSection.getKeys(false);

        for (String item : keysSellItems) {
            ConfigurationSection itemSection = config.getConfigurationSection("sell-items." + item);

            if (itemSection == null) return new HashMap<>();

            ItemStack itemStack = new ItemStack(Material.valueOf(item));
            itemStack.setAmount(itemSection.getInt("amount"));

            itemStacks.put(itemStack, itemSection.getInt("price"));
        }

        return itemStacks;
    }

    public ItemStack getBook() {
        ConfigurationSection bookItemsSection = config.getConfigurationSection("menu.book");

        if (bookItemsSection == null)
            return new ItemBuilder(Material.BOOK).setName("&cConfiguration files are corrupted!").toItemStack();

        return new ItemBuilder(Material.WRITABLE_BOOK)
                .setName(bookItemsSection.getString("name"))
                .setLore(bookItemsSection.getString("lore"))
                .toItemStack();
    }
}
