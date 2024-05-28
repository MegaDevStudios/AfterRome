package com.megadev.afterrome.config.shop.upgrade;

import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.util.Color;
import dev.mega.megacore.config.Configurator;
import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ForesterUpgradeShopConfig extends Configurator implements UpgradeShopConfig {
    public ForesterUpgradeShopConfig(@NotNull Plugin plugin, String... path) {
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

    public String getCampCookingName() {
        return Color.colorize(getString("skill.camp-cooking.name"));
    }

    public String getCampCookingLore() {
        return Color.colorize(getString("skill.camp-cooking.lore"));
    }

    public MenuItem getCampCookingItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.camp-cooking.item")))
                .setName(getCampCookingName())
                .setLore(getCampCookingLore());
    }

    public String getHaltName() {
        return Color.colorize(getString("skill.halt.name"));
    }

    public String getHaltLore() {
        return Color.colorize(getString("skill.halt.lore"));
    }

    public MenuItem getHaltItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.halt.item")))
                .setName(getHaltName())
                .setLore(getHaltLore());
    }

    public String getHorseRidingName() {
        return Color.colorize(getString("skill.horse-riding.name"));
    }

    public String getHorseRidingLore() {
        return Color.colorize(getString("skill.horse-riding.lore"));
    }

    public MenuItem getHorseRidingItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.horse-riding.item")))
                .setName(getHorseRidingName())
                .setLore(getHorseRidingLore());
    }

    public String getLadleStaffName() {
        return Color.colorize(getString("skill.ladle-staff.name"));
    }

    public String getLadleStaffLore() {
        return Color.colorize(getString("skill.ladle-staff.lore"));
    }

    public MenuItem getLadleStaffItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.ladle-staff.item")))
                .setName(getLadleStaffName())
                .setLore(getLadleStaffLore());
    }

    public String getLungCapacityName() {
        return Color.colorize(getString("skill.lung-capacity.name"));
    }

    public String getLungCapacityLore() {
        return Color.colorize(getString("skill.lung-capacity.lore"));
    }

    public MenuItem getLungCapacityItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.lung-capacity.item")))
                .setName(getLungCapacityName())
                .setLore(getLungCapacityLore());
    }

    public String getSeafaringName() {
        return Color.colorize(getString("skill.seafaring.name"));
    }

    public String getSeafaringLore() {
        return Color.colorize(getString("skill.seafaring.lore"));
    }

    public MenuItem getSeafaringItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.seafaring.item")))
                .setName(getSeafaringName())
                .setLore(getSeafaringLore());
    }
}
