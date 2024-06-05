package dev.mega.afterromeimpl.object.item;

import dev.mega.megacore.util.Color;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractItemBuilder<T extends AbstractItemBuilder<T>> {
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

    public abstract T build();

    @SuppressWarnings("unchecked")
    public T clone() {
        try {
            return (T) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return build();
    }

    public T setType(Material type) {
        itemStack.setType(type);
        return build();
    }

    public T setAmount(int amount) {
        itemStack.setAmount(amount);
        return build();
    }

    public T addEnchantment(Enchantment enchantment, int level) {
        itemStack.addEnchantment(enchantment, level);
        return build();
    }

    public T addUnsafeEnchantment(Enchantment enchantment, int level) {
        itemStack.addUnsafeEnchantment(enchantment, level);
        return build();
    }

    public T removeEnchantment(Enchantment enchantment) {
        itemStack.removeEnchantment(enchantment);
        return build();
    }

    public T setName(String name) {
        ItemMeta itemMeta = getItemMeta();
        itemMeta.displayName(fromStringToComponent(Color.getTranslated(name)));
        itemStack.setItemMeta(itemMeta);
        return build();
    }

    public T setLore(List<String> lore) {
        ItemMeta itemMeta = getItemMeta();

        Color.getTranslated(lore);

        itemMeta.lore(fromStringToComponent(lore));
        itemStack.setItemMeta(itemMeta);
        return build();
    }

    public T setLore(String... lore) {
        setLore(Arrays.asList(lore));
        return build();
    }

    public T removeLoreLine(String line) {
        ItemMeta itemMeta = itemStack.getItemMeta();

        List<String> lore = new ArrayList<>(itemMeta.getLore());
        lore.remove(line);

        itemMeta.lore(fromStringToComponent(lore));
        itemStack.setItemMeta(itemMeta);
        return build();
    }

    public T removeLoreLine(int index) {
        ItemMeta itemMeta = getItemMeta();
        List<String> lore = new ArrayList<>(itemMeta.getLore());

        lore.remove(index);
        itemMeta.lore(fromStringToComponent(lore));
        itemStack.setItemMeta(itemMeta);
        return build();
    }

    public T addLoreLine(String line) {
        ItemMeta itemMeta = getItemMeta();
        List<String> lore = itemMeta.hasLore()
                        ? new ArrayList<>(itemMeta.getLore())
                        : new ArrayList<>();

        lore.add(line);
        itemMeta.lore(fromStringToComponent(lore));
        itemStack.setItemMeta(itemMeta);
        return build();
    }

    public T addLoreLine(int index, String line) {
        ItemMeta itemMeta = getItemMeta();
        List<String> lore = itemMeta.hasLore()
                ? new ArrayList<>(itemMeta.getLore())
                : new ArrayList<>();

        lore.add(index, line);
        Color.getTranslated(lore);

        itemMeta.lore(fromStringToComponent(lore));
        itemStack.setItemMeta(itemMeta);
        return build();
    }

    public T setLoreLine(int index, String line) {
        ItemMeta itemMeta = getItemMeta();
        List<String> lore = itemMeta.hasLore() ? new ArrayList<>(itemMeta.getLore()) : new ArrayList<>();

        lore.set(index, line);

        Color.getTranslated(lore);

        itemMeta.lore(fromStringToComponent(lore));
        itemStack.setItemMeta(itemMeta);
        return build();
    }

    public T addItemFlags(ItemFlag... itemFlags) {
        ItemMeta itemMeta = getItemMeta();
        itemMeta.addItemFlags(itemFlags);
        itemStack.setItemMeta(itemMeta);
        return build();
    }

    public T removeItemFlags(ItemFlag... itemFlags) {
        ItemMeta itemMeta = getItemMeta();
        itemMeta.removeItemFlags(itemFlags);
        itemStack.setItemMeta(itemMeta);
        return build();
    }

    public T resetItemFlags() {
        ItemMeta itemMeta = getItemMeta();
        itemMeta.removeItemFlags(itemMeta.getItemFlags().toArray(new ItemFlag[0]));
        itemStack.setItemMeta(itemMeta);
        return build();
    }

    public ItemStack toItemStack() {
        return itemStack;
    }

    protected ItemMeta getItemMeta() {
        return itemStack.getItemMeta();
    }

    protected List<TextComponent> fromStringToComponent(List<String> strings) {
        return strings.stream().map(this::fromStringToComponent).toList();
    }

    protected List<TextComponent> fromStringToComponent(String... strings) {
        return fromStringToComponent(Arrays.asList(strings));
    }

    protected TextComponent fromStringToComponent(String string) {
        return Component.text(string);
    }
}
