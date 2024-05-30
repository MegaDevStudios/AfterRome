package com.megadev.afterrome.config.shop.upgrade;

import com.megadev.afterrome.object.menu.item.MenuItem;
import dev.mega.megacore.config.Configurator;

import dev.mega.megacore.util.Color;
import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class ArtisanUpgradeShopConfig extends Configurator implements UpgradeShopConfig {
    public ArtisanUpgradeShopConfig(@NotNull Plugin plugin, String... path) {
        super(plugin, path);
    }

    @Override
    public String getMenuName() {
        return Color.getTranslated(getString("menu-name"));
    }

    @Override
    public MenuItem getBackgroundItem() {
        return new MenuItem(Material.valueOf(getString("background-item"))).setName("&f");
    }

    public String getBlacksmithName() {
        return Color.getTranslated(getString("skill.blacksmith.name"));
    }

    public String getBlacksmithLore() {
        return Color.getTranslated(getString("skill.blacksmith.lore"));
    }

    public MenuItem getBlacksmithItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.blacksmith.item")))
                .setName(getBlacksmithName())
                .setLore(getBlacksmithLore());
    }

    public String getFishermanName() {
        return Color.getTranslated(getString("skill.fisherman.name"));
    }

    public String getFishermanLore() {
        return Color.getTranslated(getString("skill.fisherman.lore"));
    }

    public MenuItem getFishermanItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.fisherman.item")))
                .setName(getFishermanName())
                .setLore(getFishermanLore());
    }

    public String getHorsemanName() {
        return Color.getTranslated(getString("skill.horseman.name"));
    }

    public String getHorsemanLore() {
        return Color.getTranslated(getString("skill.horseman.lore"));
    }

    public MenuItem getHorsemanItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.horseman.item")))
                .setName(getHorsemanName())
                .setLore(getHorsemanLore());
    }

    public String getMetallurgistName() {
        return Color.getTranslated(getString("skill.metallurgist.name"));
    }

    public String getMetallurgistLore() {
        return Color.getTranslated(getString("skill.metallurgist.lore"));
    }

    public MenuItem getMetallurgistItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.metallurgist.item")))
                .setName(getMetallurgistName())
                .setLore(getMetallurgistLore());
    }

    public String getMinerName() {
        return Color.getTranslated(getString("skill.miner.name"));
    }

    public String getMinerLore() {
        return Color.getTranslated(getString("skill.miner.lore"));
    }

    public MenuItem getMinerItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.miner.item")))
                .setName(getMinerName())
                .setLore(getMinerLore());
    }

    public String getToolmakerName() {
        return Color.getTranslated(getString("skill.toolmaker.name"));
    }

    public String getToolmakerLore() {
        return Color.getTranslated(getString("skill.toolmaker.lore"));
    }

    public MenuItem getToolmakerItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.toolmaker.item")))
                .setName(getToolmakerName())
                .setLore(getToolmakerLore());
    }
}
