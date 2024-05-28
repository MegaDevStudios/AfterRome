package com.megadev.afterrome.config.shop.upgrade;

import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.util.Color;
import dev.mega.megacore.config.Configurator;

import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class SonOfMarsUpgradeShopConfig extends Configurator implements UpgradeShopConfig {
    public SonOfMarsUpgradeShopConfig(@NotNull Plugin plugin, String... path) {
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

    public String getIronInsideName() {
        return Color.colorize(getString("skill.iron-inside.name"));
    }

    public String getIronInsideLore() {
        return Color.colorize(getString("skill.iron-inside.lore"));
    }

    public MenuItem getIronInsideItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.iron-inside.item")))
                .setName(getIronInsideName())
                .setLore(getIronInsideLore());
    }

    public String getIronOutsideName() {
        return Color.colorize(getString("skill.iron-outside.name"));
    }

    public String getIronOutsideLore() {
        return Color.colorize(getString("skill.iron-outside.lore"));
    }

    public MenuItem getIronOutsideItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.iron-outside.item")))
                .setName(getIronOutsideName())
                .setLore(getIronOutsideLore());
    }

    public String getLandingName() {
        return Color.colorize(getString("skill.landing.name"));
    }

    public String getLandingLore() {
        return Color.colorize(getString("skill.landing.lore"));
    }

    public MenuItem getLandingItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.landing.item")))
                .setName(getLandingName())
                .setLore(getLandingLore());
    }

    public String getMeleeCombatName() {
        return Color.colorize(getString("skill.melee-combat.name"));
    }

    public String getMeleeCombatLore() {
        return Color.colorize(getString("skill.melee-combat.lore"));
    }

    public MenuItem getMeleeCombatItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.melee-combat.item")))
                .setName(getMeleeCombatName())
                .setLore(getMeleeCombatLore());
    }

    public String getProteinDietName() {
        return Color.colorize(getString("skill.protein-diet.name"));
    }

    public String getProteinDietLore() {
        return Color.colorize(getString("skill.protein-diet.lore"));
    }

    public MenuItem getProteinDietItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.protein-diet.item")))
                .setName(getProteinDietName())
                .setLore(getProteinDietLore());
    }

    public String getShootingName() {
        return Color.colorize(getString("skill.shooting.name"));
    }

    public String getShootingLore() {
        return Color.colorize(getString("skill.shooting.lore"));
    }

    public MenuItem getShootingItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.shooting.item")))
                .setName(getShootingName())
                .setLore(getShootingLore());
    }
}
