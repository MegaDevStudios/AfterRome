package com.megadev.afterrome.config.shop.upgrade;

import com.megadev.afterrome.object.menu.item.MenuItem;
import dev.mega.megacore.config.Configurator;

import dev.mega.megacore.util.Color;
import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;


public class SheriffUpgradeShopConfig extends Configurator implements UpgradeShopConfig {
    public SheriffUpgradeShopConfig(@NotNull Plugin plugin, String... path) {
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

    public String getChaseName() {
        return Color.getTranslated((String) getValue("skill.chase.name"));
    }

    public String getChaseLore() {
        return Color.getTranslated((String) getValue("skill.chase.lore"));
    }

    public MenuItem getChaseItem() {
        return new MenuItem(
                Material.valueOf((String) getValue("skill.chase.item")))
                .setName(getChaseName())
                .setLore(getChaseLore());
    }

    public String getCriminologyName() {
        return Color.getTranslated((String) getValue("skill.criminology.name"));
    }

    public String getCriminologyLore() {
        return Color.getTranslated((String) getValue("skill.criminology.lore"));
    }

    public MenuItem getCriminologyItem() {
        return new MenuItem(
                Material.valueOf((String) getValue("skill.criminology.item")))
                .setName(getCriminologyName())
                .setLore(getCriminologyLore());
    }

    public String getDonutsName() {
        return Color.getTranslated((String) getValue("skill.donuts.name"));
    }

    public String getDonutsLore() {
        return Color.getTranslated((String) getValue("skill.donuts.lore"));
    }

    public MenuItem getDonutsItem() {
        return new MenuItem(
                Material.valueOf((String) getValue("skill.donuts.item")))
                .setName(getDonutsName())
                .setLore(getDonutsLore());
    }

    public String getHoldingName() {
        return Color.getTranslated((String) getValue("skill.holding.name"));
    }

    public String getHoldingLore() {
        return Color.getTranslated((String) getValue("skill.holding.lore"));
    }

    public MenuItem getHoldingItem() {
        return new MenuItem(
                Material.valueOf((String) getValue("skill.holding.item")))
                .setName(getHoldingName())
                .setLore(getHoldingLore());
    }

    public String getShortBarreledName() {
        return Color.getTranslated((String) getValue("skill.short-barreled.name"));
    }

    public String getShortBarreledLore() {
        return Color.getTranslated((String) getValue("skill.short-barreled.lore"));
    }

    public MenuItem getShortBarreledItem() {
        return new MenuItem(
                Material.valueOf((String) getValue("skill.short-barreled.item")))
                .setName(getShortBarreledName())
                .setLore(getShortBarreledLore());
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
