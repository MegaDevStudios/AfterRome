package com.megadev.afterrome.config.shop.upgrade;

import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.util.Color;
import dev.mega.megacore.config.Configurator;
import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;

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

    public String getBlacksmithName() {
        return Color.colorize(getString("skill.blacksmith.name"));
    }

    public String getBlacksmithLore() {
        return Color.colorize(getString("skill.blacksmith.name"));
    }

    public MenuItem getBlacksmithItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.blacksmith.item")))
                .setName(getBlacksmithName())
                .setLore(getBlacksmithLore());
    }

    public String getFishermanName() {
        return Color.colorize(getString("skill.fisherman.name"));
    }

    public String getFishermanLore() {
        return Color.colorize(getString("skill.fisherman.name"));
    }

    public MenuItem getFishermanItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.fisherman.item")))
                .setName(getFishermanName())
                .setLore(getFishermanLore());
    }

    public String getHorsemanName() {
        return Color.colorize(getString("skill.horseman.name"));
    }

    public String getHorsemanLore() {
        return Color.colorize(getString("skill.horseman.name"));
    }

    public MenuItem getHorsemanItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.horseman.item")))
                .setName(getHorsemanName())
                .setLore(getHorsemanLore());
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
