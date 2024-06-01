package com.megadev.afterrome.config.shop.upgrade;

import com.megadev.afterrome.object.menu.item.MenuItem;
import dev.mega.megacore.config.Configurator;
import dev.mega.megacore.util.Color;
import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class EngineerUpgradeShopConfig extends Configurator implements UpgradeShopConfig {
    public EngineerUpgradeShopConfig(@NotNull Plugin plugin, String... path) {
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

    public String getArmorerName() {
        return Color.getTranslated((String) getValue("skill.armorer.name"));
    }

    public String getArmorerLore() {
        return Color.getTranslated((String) getValue("skill.armorer.lore"));
    }

    public MenuItem getArmorerItem() {
        return new MenuItem(
                Material.valueOf((String) getValue("skill.armorer.item")))
                .setName(getArmorerName())
                .setLore(getArmorerLore());
    }

    public String getBosnianArtilleryName() {
        return Color.getTranslated((String) getValue("skill.bosnian-artillery.name"));
    }

    public String getBosnianArtilleryLore() {
        return Color.getTranslated((String) getValue("skill.bosnian-artillery.lore"));
    }

    public MenuItem getBosnianArtilleryItem() {
        return new MenuItem(
                Material.valueOf((String) getValue("skill.bosnian-artillery.item")))
                .setName(getBosnianArtilleryName())
                .setLore(getBosnianArtilleryLore());
    }

    public String getChemicalWeaponsName() {
        return Color.getTranslated((String) getValue("skill.chemical-weapons.name"));
    }

    public String getChemicalWeaponsLore() {
        return Color.getTranslated((String) getValue("skill.chemical-weapons.lore"));
    }

    public MenuItem getChemicalWeaponsItem() {
        return new MenuItem(
                Material.valueOf((String) getValue("skill.chemical-weapons.item")))
                .setName(getChemicalWeaponsName())
                .setLore(getChemicalWeaponsLore());
    }

    public String getDrawingsName() {
        return Color.getTranslated((String) getValue("skill.drawings.name"));
    }

    public String getDrawingsLore() {
        return Color.getTranslated((String) getValue("skill.drawings.lore"));
    }

    public MenuItem getDrawingsItem() {
        return new MenuItem(
                Material.valueOf((String) getValue("skill.drawings.item")))
                .setName(getDrawingsName())
                .setLore(getDrawingsLore());
    }

    public String getHeavyIndustryName() {
        return Color.getTranslated((String) getValue("skill.heavy-industry.name"));
    }

    public String getHeavyIndustryLore() {
        return Color.getTranslated((String) getValue("skill.heavy-industry.lore"));
    }

    public MenuItem getHeavyIndustryItem() {
        return new MenuItem(
                Material.valueOf((String) getValue("skill.heavy-industry.item")))
                .setName(getHeavyIndustryName())
                .setLore(getHeavyIndustryLore());
    }

    public String getModificationsName() {
        return Color.getTranslated((String) getValue("skill.modifications.name"));
    }

    public String getModificationsLore() {
        return Color.getTranslated((String) getValue("skill.modifications.lore"));
    }

    public MenuItem getModificationsItem() {
        return new MenuItem(
                Material.valueOf((String) getValue("skill.modifications.item")))
                .setName(getModificationsName())
                .setLore(getModificationsLore());
    }

}
