package com.megadev.afterrome.config.shop.upgrade;

import com.megadev.afterrome.object.menu.item.MenuItem;
import dev.mega.megacore.config.Configurator;
import dev.mega.megacore.util.Color;
import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class ForesterUpgradeShopConfig extends Configurator implements UpgradeShopConfig {
    public ForesterUpgradeShopConfig(@NotNull Plugin plugin, String... path) {
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

    public String getCampCookingName() {
        return Color.getTranslated((String) getValue("skill.camp-cooking.name"));
    }

    public String getCampCookingLore() {
        return Color.getTranslated((String) getValue("skill.camp-cooking.lore"));
    }

    public MenuItem getCampCookingItem() {
        return new MenuItem(
                Material.valueOf((String) getValue("skill.camp-cooking.item")))
                .setName(getCampCookingName())
                .setLore(getCampCookingLore());
    }

    public String getHaltName() {
        return Color.getTranslated((String) getValue("skill.halt.name"));
    }

    public String getHaltLore() {
        return Color.getTranslated((String) getValue("skill.halt.lore"));
    }

    public MenuItem getHaltItem() {
        return new MenuItem(
                Material.valueOf((String) getValue("skill.halt.item")))
                .setName(getHaltName())
                .setLore(getHaltLore());
    }

    public String getHorseRidingName() {
        return Color.getTranslated((String) getValue("skill.horse-riding.name"));
    }

    public String getHorseRidingLore() {
        return Color.getTranslated((String) getValue("skill.horse-riding.lore"));
    }

    public MenuItem getHorseRidingItem() {
        return new MenuItem(
                Material.valueOf((String) getValue("skill.horse-riding.item")))
                .setName(getHorseRidingName())
                .setLore(getHorseRidingLore());
    }

    public String getLadleStaffName() {
        return Color.getTranslated((String) getValue("skill.ladle-staff.name"));
    }

    public String getLadleStaffLore() {
        return Color.getTranslated((String) getValue("skill.ladle-staff.lore"));
    }

    public MenuItem getLadleStaffItem() {
        return new MenuItem(
                Material.valueOf((String) getValue("skill.ladle-staff.item")))
                .setName(getLadleStaffName())
                .setLore(getLadleStaffLore());
    }

    public String getLungCapacityName() {
        return Color.getTranslated((String) getValue("skill.lung-capacity.name"));
    }

    public String getLungCapacityLore() {
        return Color.getTranslated((String) getValue("skill.lung-capacity.lore"));
    }

    public MenuItem getLungCapacityItem() {
        return new MenuItem(
                Material.valueOf((String) getValue("skill.lung-capacity.item")))
                .setName(getLungCapacityName())
                .setLore(getLungCapacityLore());
    }

    public String getSeafaringName() {
        return Color.getTranslated((String) getValue("skill.seafaring.name"));
    }

    public String getSeafaringLore() {
        return Color.getTranslated((String) getValue("skill.seafaring.lore"));
    }

    public MenuItem getSeafaringItem() {
        return new MenuItem(
                Material.valueOf((String) getValue("skill.seafaring.item")))
                .setName(getSeafaringName())
                .setLore(getSeafaringLore());
    }
}
