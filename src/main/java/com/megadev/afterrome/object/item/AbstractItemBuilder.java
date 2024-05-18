package com.megadev.afterrome.object.item;

import com.megadev.afterrome.util.Color;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


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

    public abstract T getThis();

    public abstract T clone();

    public T setType(Material type) {
        itemStack.setType(type);
        return getThis();
    }

    public T setAmount(int amount) {
        itemStack.setAmount(amount);
        return getThis();
    }

    public T addEnchantment(Enchantment enchantment, int level) {
        itemStack.addEnchantment(enchantment, level);
        return getThis();
    }

    public T addUnsafeEnchantment(Enchantment enchantment, int level) {
        itemStack.addUnsafeEnchantment(enchantment, level);
        return getThis();
    }

    public T removeEnchantment(Enchantment enchantment) {
        itemStack.removeEnchantment(enchantment);
        return getThis();
    }

    public T setName(String name) {
        ItemMeta itemMeta = getItemMeta();
        itemMeta.setDisplayName(Color.colorize(name));
        itemStack.setItemMeta(itemMeta);
        return getThis();
    }

    public T setLore(List<String> lore) {
        ItemMeta itemMeta = getItemMeta();

        lore = lore.stream()
                .map(Color::colorize)
                .collect(Collectors.toList());

        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return getThis();
    }

    public T setLore(String... lore) {
        setLore(Arrays.asList(lore));
        return getThis();
    }

    public T removeLoreLine(String line) {
        ItemMeta itemMeta = itemStack.getItemMeta();

        List<String> lore = new ArrayList<>(itemMeta.getLore());

        lore.remove(line);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return getThis();
    }

    public T removeLoreLine(int index) {
        ItemMeta itemMeta = getItemMeta();
        List<String> lore = new ArrayList<>(itemMeta.getLore());

        lore.remove(index);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return getThis();
    }

    public T addLoreLine(String line) {
        ItemMeta itemMeta = getItemMeta();
        List<String> lore = itemMeta.hasLore() ? new ArrayList<>(itemMeta.getLore()) : new ArrayList<>();

        lore.add(line);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return getThis();
    }

    public T addLoreLine(int index, String line) {
        ItemMeta itemMeta = getItemMeta();
        List<String> lore = itemMeta.hasLore() ? new ArrayList<>(itemMeta.getLore()) : new ArrayList<>();

        lore.add(index, line);
        lore = lore.stream()
                .map(Color::colorize)
                .collect(Collectors.toList());

        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return getThis();
    }

    public T setLoreLine(int index, String line) {
        ItemMeta itemMeta = getItemMeta();
        List<String> lore = itemMeta.hasLore() ? new ArrayList<>(itemMeta.getLore()) : new ArrayList<>();

        lore.set(index, line);

        lore = lore.stream()
                .map(Color::colorize)
                .collect(Collectors.toList());

        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return getThis();
    }

    public T addItemFlags(ItemFlag... itemFlags) {
        ItemMeta itemMeta = getItemMeta();
        itemMeta.addItemFlags(itemFlags);
        itemStack.setItemMeta(itemMeta);
        return getThis();
    }

    public T removeItemFlags(ItemFlag... itemFlags) {
        ItemMeta itemMeta = getItemMeta();
        itemMeta.removeItemFlags(itemFlags);
        itemStack.setItemMeta(itemMeta);
        return getThis();
    }

    public T resetItemFlags() {
        ItemMeta itemMeta = getItemMeta();
        itemMeta.removeItemFlags(itemMeta.getItemFlags().toArray(new ItemFlag[0]));
        itemStack.setItemMeta(itemMeta);
        return getThis();
    }

    public ItemStack toItemStack() {
        return itemStack;
    }

    protected ItemMeta getItemMeta() {
        return itemStack.getItemMeta();
    }
}
