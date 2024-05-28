package com.megadev.afterrome.config.shop.upgrade;

import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.util.Color;
import dev.mega.megacore.config.Configurator;

import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;


public class SheriffUpgradeShopConfig extends Configurator implements UpgradeShopConfig {
    public SheriffUpgradeShopConfig(@NotNull Plugin plugin, String... path) {
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

    public String getChaseName() {
        return Color.colorize(getString("skill.chase.name"));
    }

    public String getChaseLore() {
        return Color.colorize(getString("skill.chase.lore"));
    }

    public MenuItem getChaseItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.chase.item")))
                .setName(getChaseName())
                .setLore(getChaseLore());
    }

    public String getCriminologyName() {
        return Color.colorize(getString("skill.criminology.name"));
    }

    public String getCriminologyLore() {
        return Color.colorize(getString("skill.criminology.lore"));
    }

    public MenuItem getCriminologyItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.criminology.item")))
                .setName(getCriminologyName())
                .setLore(getCriminologyLore());
    }

    public String getDonutsName() {
        return Color.colorize(getString("skill.donuts.name"));
    }

    public String getDonutsLore() {
        return Color.colorize(getString("skill.donuts.lore"));
    }

    public MenuItem getDonutsItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.donuts.item")))
                .setName(getDonutsName())
                .setLore(getDonutsLore());
    }

    public String getHoldingName() {
        return Color.colorize(getString("skill.holding.name"));
    }

    public String getHoldingLore() {
        return Color.colorize(getString("skill.holding.lore"));
    }

    public MenuItem getHoldingItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.holding.item")))
                .setName(getHoldingName())
                .setLore(getHoldingLore());
    }

    public String getShortBarreledName() {
        return Color.colorize(getString("skill.short-barreled.name"));
    }

    public String getShortBarreledLore() {
        return Color.colorize(getString("skill.short-barreled.lore"));
    }

    public MenuItem getShortBarreledItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.short-barreled.item")))
                .setName(getShortBarreledName())
                .setLore(getShortBarreledLore());
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
