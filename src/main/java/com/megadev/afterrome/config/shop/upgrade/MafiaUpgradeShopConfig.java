package com.megadev.afterrome.config.shop.upgrade;

import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.util.Color;

import dev.mega.megacore.config.Configurator;

import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class MafiaUpgradeShopConfig extends Configurator implements UpgradeShopConfig {
    public MafiaUpgradeShopConfig(@NotNull Plugin plugin, String... path) {
        super(plugin, path);
    }

    @Override
    public String getMenuName() {
        return Color.colorize(getString("menu-name"));
    }

    @Override
    public MenuItem getBackgroundItem() {
        return new MenuItem(Material.valueOf(getString("background-item"))).setName("&f");
    }

    public String getHackName() {
        return Color.colorize(getString("skill.hack.name"));
    }

    public String getHackLore() {
        return Color.colorize(getString("skill.hack.lore"));
    }

    public MenuItem getHackItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.hack.item")))
                .setName(getHackName())
                .setLore(getHackLore());
    }

    public String getKillerName() {
        return Color.colorize(getString("skill.killer.name"));
    }

    public String getKillerLore() {
        return Color.colorize(getString("skill.killer.lore"));
    }

    public MenuItem getKillerItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.killer.item")))
                .setName(getKillerName())
                .setLore(getKillerLore());
    }

    public String getPoisonName() {
        return Color.colorize(getString("skill.poison.name"));
    }

    public String getPoisonLore() {
        return Color.colorize(getString("skill.poison.lore"));
    }

    public MenuItem getPoisonItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.poison.item")))
                .setName(getPoisonName())
                .setLore(getPoisonLore());
    }

    public String getSlipperyName() {
        return Color.colorize(getString("skill.slippery.name"));
    }

    public String getSlipperyLore() {
        return Color.colorize(getString("skill.slippery.lore"));
    }

    public MenuItem getSlipperyItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.slippery.item")))
                .setName(getSlipperyName())
                .setLore(getSlipperyLore());
    }

    public String getStealthName() {
        return Color.colorize(getString("skill.stealth.name"));
    }

    public String getStealthLore() {
        return Color.colorize(getString("skill.stealth.lore"));
    }

    public MenuItem getStealthItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.stealth.item")))
                .setName(getStealthName())
                .setLore(getStealthLore());
    }

    public String getWakeName() {
        return Color.colorize(getString("skill.wake.name"));
    }

    public String getWakeLore() {
        return Color.colorize(getString("skill.wake.lore"));
    }

    public MenuItem getWakeItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.wake.item")))
                .setName(getWakeName())
                .setLore(getWakeLore());
    }
}
