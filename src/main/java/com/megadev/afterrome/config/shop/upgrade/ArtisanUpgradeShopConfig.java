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
        return Color.getTranslated((String) getValue("menu-name"));
    }

    @Override
    public MenuItem getBackgroundItem() {
        return new MenuItem(Material.valueOf((String) getValue("background-item"))).setName("&f");
    }

    public String getBlacksmithName() {
        return Color.getTranslated((String) getValue("skill.blacksmith.name"));
    }

    public String getBlacksmithLore() {
        return Color.getTranslated((String) getValue("skill.blacksmith.lore"));
    }

    public MenuItem getBlacksmithItem() {
        return new MenuItem(
                Material.valueOf((String) getValue("skill.blacksmith.item")))
                .setName(getBlacksmithName())
                .setLore(getBlacksmithLore());
    }

    public String getFishermanName() {
        return Color.getTranslated((String) getValue("skill.fisherman.name"));
    }

    public String getFishermanLore() {
        return Color.getTranslated((String) getValue("skill.fisherman.lore"));
    }

    public MenuItem getFishermanItem() {
        return new MenuItem(
                Material.valueOf((String) getValue("skill.fisherman.item")))
                .setName(getFishermanName())
                .setLore(getFishermanLore());
    }

    public String getHorsemanName() {
        return Color.getTranslated((String) getValue("skill.horseman.name"));
    }

    public String getHorsemanLore() {
        return Color.getTranslated((String) getValue("skill.horseman.lore"));
    }

    public MenuItem getHorsemanItem() {
        return new MenuItem(
                Material.valueOf((String) getValue("skill.horseman.item")))
                .setName(getHorsemanName())
                .setLore(getHorsemanLore());
    }

    public String getMetallurgistName() {
        return Color.getTranslated((String) getValue("skill.metallurgist.name"));
    }

    public String getMetallurgistLore() {
        return Color.getTranslated((String) getValue("skill.metallurgist.lore"));
    }

    public MenuItem getMetallurgistItem() {
        return new MenuItem(
                Material.valueOf((String) getValue("skill.metallurgist.item")))
                .setName(getMetallurgistName())
                .setLore(getMetallurgistLore());
    }

    public String getMinerName() {
        return Color.getTranslated((String) getValue("skill.miner.name"));
    }

    public String getMinerLore() {
        return Color.getTranslated((String) getValue("skill.miner.lore"));
    }

    public MenuItem getMinerItem() {
        return new MenuItem(
                Material.valueOf((String) getValue("skill.miner.item")))
                .setName(getMinerName())
                .setLore(getMinerLore());
    }

    public String getToolmakerName() {
        return Color.getTranslated((String) getValue("skill.toolmaker.name"));
    }

    public String getToolmakerLore() {
        return Color.getTranslated((String) getValue("skill.toolmaker.lore"));
    }

    public MenuItem getToolmakerItem() {
        return new MenuItem(
                Material.valueOf((String) getValue("skill.toolmaker.item")))
                .setName(getToolmakerName())
                .setLore(getToolmakerLore());
    }
}
