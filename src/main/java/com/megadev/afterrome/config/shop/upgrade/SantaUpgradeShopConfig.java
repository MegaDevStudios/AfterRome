package com.megadev.afterrome.config.shop.upgrade;

import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.util.Color;
import dev.mega.megacore.config.Configurator;
import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SantaUpgradeShopConfig extends Configurator implements UpgradeShopConfig {
    public SantaUpgradeShopConfig(@NotNull Plugin plugin, String... path) {
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

    public String getForTheFaithName() {
        return Color.colorize(getString("skill.for-the-faith.name"));
    }

    public String getForTheFaithLore() {
        return Color.colorize(getString("skill.for-the-faith.lore"));
    }

    public MenuItem getForTheFaithItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.for-the-faith.item")))
                .setName(getForTheFaithName())
                .setLore(getForTheFaithLore());
    }

    public String getForTheGraceName() {
        return Color.colorize(getString("skill.for-the-grace.name"));
    }

    public String getForTheGraceLore() {
        return Color.colorize(getString("skill.for-the-grace.lore"));
    }

    public MenuItem getForTheGraceItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.for-the-grace.item")))
                .setName(getForTheGraceName())
                .setLore(getForTheGraceLore());
    }

    public String getForTheHomeOfTheHolyName() {
        return Color.colorize(getString("skill.for-the-home-of-the-holy.name"));
    }

    public String getForTheHomeOfTheHolyLore() {
        return Color.colorize(getString("skill.for-the-home-of-the-holy.lore"));
    }

    public MenuItem getForTheHomeOfTheHolyItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.for-the-home-of-the-holy.item")))
                .setName(getForTheHomeOfTheHolyName())
                .setLore(getForTheHomeOfTheHolyLore());
    }

    public String getForTheMightOfOurLordName() {
        return Color.colorize(getString("skill.for-the-might-of-our-lord.name"));
    }

    public String getForTheMightOfOurLordLore() {
        return Color.colorize(getString("skill.for-the-might-of-our-lord.lore"));
    }

    public MenuItem getForTheMightOfOurLordItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.for-the-might-of-our-lord.item")))
                .setName(getForTheMightOfOurLordName())
                .setLore(getForTheMightOfOurLordLore());
    }

    public String getForTheWayOfTheSwordName() {
        return Color.colorize(getString("skill.for-the-way-of-the-sword.name"));
    }

    public String getForTheWayOfTheSwordLore() {
        return Color.colorize(getString("skill.for-the-way-of-the-sword.lore"));
    }

    public MenuItem getForTheWayOfTheSwordItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.for-the-way-of-the-sword.item")))
                .setName(getForTheWayOfTheSwordName())
                .setLore(getForTheWayOfTheSwordLore());
    }

    public String getHighlightsName() {
        return Color.colorize(getString("skill.highlights.name"));
    }

    public String getHighlightsLore() {
        return Color.colorize(getString("skill.highlights.lore"));
    }

    public MenuItem getHighlightsItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.highlights.item")))
                .setName(getHighlightsName())
                .setLore(getHighlightsLore());
    }
}
