package com.megadev.afterrome.object.item;

import com.megadev.afterrome.object.menu.item.MenuItem;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.UUID;

public class HeadBuilder extends AbstractItemBuilder<HeadBuilder> {
    public HeadBuilder(ItemStack itemStack) {
        super(itemStack);
    }

    public HeadBuilder(String texture) {
        super(new ItemStack(Material.PLAYER_HEAD));

        SkullMeta headMeta = (SkullMeta) getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), Math.random() + "");
        profile.getProperties().put("textures", new Property("textures", texture));

        try {
            Field field = headMeta.getClass().getDeclaredField("profile");
            field.setAccessible(true);
            field.set(headMeta, profile);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException exception) {
            exception.printStackTrace();
        }

        itemStack.setItemMeta(headMeta);
    }

    public MenuItem toMenuItem() {
        return new MenuItem(this.toItemStack());
    }

    @Override
    public HeadBuilder getThis() {
        return this;
    }

    @Override
    public HeadBuilder clone() {
        return new HeadBuilder(itemStack.clone());
    }
}
