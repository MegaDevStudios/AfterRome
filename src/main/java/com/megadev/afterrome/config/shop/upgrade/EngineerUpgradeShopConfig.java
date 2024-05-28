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
        return Color.getTranslated(getString("menu-name"));
    }

    @Override
    public MenuItem getBackgroundItem() {
        return new MenuItem(Material.valueOf(getString("background-item"))).setName("&f");
    }

    public String getArmorerName() {
        return Color.getTranslated(getString("skill.armorer.name"));
    }

    public String getArmorerLore() {
        return Color.getTranslated(getString("skill.armorer.lore"));
    }

    public MenuItem getArmorerItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.armorer.item")))
                .setName(getArmorerName())
                .setLore(getArmorerLore());
    }

    public String getBosnianArtilleryName() {
        return Color.getTranslated(getString("skill.bosnian-artillery.name"));
    }

    public String getBosnianArtilleryLore() {
        return Color.getTranslated(getString("skill.bosnian-artillery.lore"));
    }

    public MenuItem getBosnianArtilleryItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.bosnian-artillery.item")))
                .setName(getBosnianArtilleryName())
                .setLore(getBosnianArtilleryLore());
    }

    public String getChemicalWeaponsName() {
        return Color.getTranslated(getString("skill.chemical-weapons.name"));
    }

    public String getChemicalWeaponsLore() {
        return Color.getTranslated(getString("skill.chemical-weapons.lore"));
    }

    public MenuItem getChemicalWeaponsItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.chemical-weapons.item")))
                .setName(getChemicalWeaponsName())
                .setLore(getChemicalWeaponsLore());
    }

    public String getDrawingsName() {
        return Color.getTranslated(getString("skill.drawings.name"));
    }

    public String getDrawingsLore() {
        return Color.getTranslated(getString("skill.drawings.lore"));
    }

    public MenuItem getDrawingsItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.drawings.item")))
                .setName(getDrawingsName())
                .setLore(getDrawingsLore());
    }

    public String getHeavyIndustryName() {
        return Color.getTranslated(getString("skill.heavy-industry.name"));
    }

    public String getHeavyIndustryLore() {
        return Color.getTranslated(getString("skill.heavy-industry.lore"));
    }

    public MenuItem getHeavyIndustryItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.heavy-industry.item")))
                .setName(getHeavyIndustryName())
                .setLore(getHeavyIndustryLore());
    }

    public String getModificationsName() {
        return Color.getTranslated(getString("skill.modifications.name"));
    }

    public String getModificationsLore() {
        return Color.getTranslated(getString("skill.modifications.lore"));
    }

    public MenuItem getModificationsItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.modifications.item")))
                .setName(getModificationsName())
                .setLore(getModificationsLore());
    }

}
