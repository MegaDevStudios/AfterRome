package dev.mega.afterromeimpl.object.item;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import dev.mega.megacore.util.MegaCoreUtil;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.UUID;

public class HeadBuilder extends AbstractItemBuilder<HeadBuilder> {
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
            MegaCoreUtil.getLogger().warning("!!!!!!!");
        }

        itemStack.setItemMeta(headMeta);
    }

    @Override
    public HeadBuilder build()  {
        return this;
    }
}
