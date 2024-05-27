package com.megadev.afterrome.config.shop.upgrade;

import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.util.Color;

import dev.mega.megacore.config.Configurator;

import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class AgronomistUpgradeShopConfig extends Configurator implements UpgradeShopConfig{
    public AgronomistUpgradeShopConfig(@NotNull Plugin plugin, String... path) {
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

    public String getButcherName() {
        return Color.colorize(getString("skill.butcher.name"));
    }

    public String getCookName() {
        return Color.colorize(getString("skill.cook.name"));
    }

    public String getFarmerName() {
        return Color.colorize(getString("skill.farmer.name"));
    }

    public String getHatcherName() {
        return Color.colorize(getString("skill.hatcher.name"));
    }

    public String getLumberjackName() {
        return Color.colorize(getString("skill.lumberjack.name"));
    }

    public String getTannerName() {
        return Color.colorize(getString("skill.tanner.name"));
    }

    public String getButcherLore() {
        return Color.colorize(getString("skill.butcher.name"));
    }

    public String getCookLore() {
        return Color.colorize(getString("skill.cook.name"));
    }

    public String getFarmerLore() {
        return Color.colorize(getString("skill.farmer.name"));
    }

    public String getHatcherLore() {
        return Color.colorize(getString("skill.hatcher.name"));
    }

    public String getLumberjackLore() {
        return Color.colorize(getString("skill.lumberjack.name"));
    }

    public String getTannerLore() {
        return Color.colorize(getString("skill.tanner.name"));
    }

    public MenuItem getButcherItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.butcher.item")))
                .setName(getButcherName())
                .setLore(getButcherLore());
    }

    public MenuItem getCookItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.cook.item")))
                .setName(getCookName())
                .setLore(getCookLore());
    }

    public MenuItem getFarmerItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.farmer.item")))
                .setName(getFarmerName())
                .setLore(getFarmerLore());
    }

    public MenuItem getHatcherItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.hatcher.item")))
                .setName(getHatcherName())
                .setLore(getHatcherLore());
    }

    public MenuItem getLumberjackItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.lumberjack.item")))
                .setName(getLumberjackName())
                .setLore(getLumberjackLore());
    }

    public MenuItem getTannerItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.tanner.item")))
                .setName(getTannerName())
                .setLore(getTannerLore());
    }
}
