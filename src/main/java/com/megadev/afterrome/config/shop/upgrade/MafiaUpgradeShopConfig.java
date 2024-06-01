package com.megadev.afterrome.config.shop.upgrade;

import com.megadev.afterrome.object.menu.item.MenuItem;

import dev.mega.megacore.config.Configurator;

import dev.mega.megacore.util.Color;
import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class MafiaUpgradeShopConfig extends Configurator implements UpgradeShopConfig {
    public MafiaUpgradeShopConfig(@NotNull Plugin plugin, String... path) {
        super(plugin, path);
    }

    @Override
    public String getMenuName() {
        return Color.getTranslated((String) getValue("menu-name"));
    }

    @Override
    public MenuItem getBackgroundItem() {
        return new MenuItem(Material.valueOf((String) getValue("background-item"))).setName("&f");
    }

    public String getHackName() {
        return Color.getTranslated((String) getValue("skill.hack.name"));
    }

    public String getHackLore() {
        return Color.getTranslated((String) getValue("skill.hack.lore"));
    }

    public MenuItem getHackItem() {
        return new MenuItem(
                Material.valueOf((String) getValue("skill.hack.item")))
                .setName(getHackName())
                .setLore(getHackLore());
    }

    public String getKillerName() {
        return Color.getTranslated((String) getValue("skill.killer.name"));
    }

    public String getKillerLore() {
        return Color.getTranslated((String) getValue("skill.killer.lore"));
    }

    public MenuItem getKillerItem() {
        return new MenuItem(
                Material.valueOf((String) getValue("skill.killer.item")))
                .setName(getKillerName())
                .setLore(getKillerLore());
    }

    public String getPoisonName() {
        return Color.getTranslated((String) getValue("skill.poison.name"));
    }

    public String getPoisonLore() {
        return Color.getTranslated((String) getValue("skill.poison.lore"));
    }

    public MenuItem getPoisonItem() {
        return new MenuItem(
                Material.valueOf((String) getValue("skill.poison.item")))
                .setName(getPoisonName())
                .setLore(getPoisonLore());
    }

    public String getSlipperyName() {
        return Color.getTranslated((String) getValue("skill.slippery.name"));
    }

    public String getSlipperyLore() {
        return Color.getTranslated((String) getValue("skill.slippery.lore"));
    }

    public MenuItem getSlipperyItem() {
        return new MenuItem(
                Material.valueOf((String) getValue("skill.slippery.item")))
                .setName(getSlipperyName())
                .setLore(getSlipperyLore());
    }

    public String getStealthName() {
        return Color.getTranslated((String) getValue("skill.stealth.name"));
    }

    public String getStealthLore() {
        return Color.getTranslated((String) getValue("skill.stealth.lore"));
    }

    public MenuItem getStealthItem() {
        return new MenuItem(
                Material.valueOf((String) getValue("skill.stealth.item")))
                .setName(getStealthName())
                .setLore(getStealthLore());
    }

    public String getWakeName() {
        return Color.getTranslated((String) getValue("skill.wake.name"));
    }

    public String getWakeLore() {
        return Color.getTranslated((String) getValue("skill.wake.lore"));
    }

    public MenuItem getWakeItem() {
        return new MenuItem(
                Material.valueOf((String) getValue("skill.wake.item")))
                .setName(getWakeName())
                .setLore(getWakeLore());
    }
}
