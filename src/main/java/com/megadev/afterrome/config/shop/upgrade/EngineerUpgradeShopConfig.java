package com.megadev.afterrome.config.shop.upgrade;

import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.util.Color;
import dev.mega.megacore.config.Configurator;
import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EngineerUpgradeShopConfig extends Configurator implements UpgradeShopConfig {
    public EngineerUpgradeShopConfig(@NotNull Plugin plugin, String... path) {
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

    public String getArmorerName() {
        return Color.colorize(getString("skill.armorer.name")); //тут надо поменять TODO
    }

    public String getArmorerLore() {
        return Color.colorize(getString("skill.armorer.name"));
    }

    public MenuItem getArmorerItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.armorer.item")))
                .setName(getArmorerName())
                .setLore(getArmorerLore());
    }

    public String getBosnianArtilleryName() {
        return Color.colorize(getString("skill.bosnian-artillery.name"));
    }

    public String getBosnianArtilleryLore() {
        return Color.colorize(getString("skill.bosnian-artillery.name"));
    }

    public MenuItem getBosnianArtilleryItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.bosnian-artillery.item")))
                .setName(getBosnianArtilleryName())
                .setLore(getBosnianArtilleryLore());
    }

    public String getChemicalWeaponsName() {
        return Color.colorize(getString("skill.chemical-weapons.name"));
    }

    public String getChemicalWeaponsLore() {
        return Color.colorize(getString("skill.chemical-weapons.name"));
    }

    public MenuItem getChemicalWeaponsItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.chemical-weapons.item")))
                .setName(getChemicalWeaponsName())
                .setLore(getChemicalWeaponsLore());
    }

    public String getMetallurgistName() {
        return Color.colorize(getString("skill.metallurgist.name"));
    }

    public String getMetallurgistLore() {
        return Color.colorize(getString("skill.metallurgist.name"));
    }

    public MenuItem getMetallurgistItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.metallurgist.item")))
                .setName(getMetallurgistName())
                .setLore(getMetallurgistLore());
    }

    public String getMinerName() {
        return Color.colorize(getString("skill.miner.name"));
    }

    public String getMinerLore() {
        return Color.colorize(getString("skill.miner.name"));
    }

    public MenuItem getMinerItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.miner.item")))
                .setName(getMinerName())
                .setLore(getMinerLore());
    }

    public String getToolmakerName() {
        return Color.colorize(getString("skill.toolmaker.name"));
    }

    public String getToolmakerLore() {
        return Color.colorize(getString("skill.toolmaker.name"));
    }

    public MenuItem getToolmakerItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.toolmaker.item")))
                .setName(getToolmakerName())
                .setLore(getToolmakerLore());
    }

}
