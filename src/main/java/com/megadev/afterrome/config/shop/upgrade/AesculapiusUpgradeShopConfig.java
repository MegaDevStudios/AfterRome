package com.megadev.afterrome.config.shop.upgrade;

import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.util.Color;

import dev.mega.megacore.config.Configurator;

import lombok.Getter;

import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

@Getter
public class AesculapiusUpgradeShopConfig extends Configurator implements UpgradeShopConfig {

    public AesculapiusUpgradeShopConfig(@NotNull Plugin plugin, String... path) {
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

    public String getAlchemyName() {
        return Color.colorize(getString("skill.alchemy.name"));
    }

    public String getBrutalSurgeryName() {
        return Color.colorize(getString("skill.brutal-surgery.name"));
    }

    public String getCombatStimulantsName() {
        return Color.colorize(getString("skill.combat-stimulants.name"));
    }

    public String getDoctorMaskName() {
        return Color.colorize(getString("skill.doctor-mask.name"));
    }

    public String getHealingName() {
        return Color.colorize(getString("skill.healing.name"));
    }

    public String getUrineTherapyName() {
        return Color.colorize(getString("skill.urine-therapy.name"));
    }

    public String getAlchemyLore() {
        return Color.colorize(getString("skill.alchemy.lore"));
    }

    public String getBrutalSurgeryLore() {
        return Color.colorize(getString("skill.brutal-surgery.lore"));
    }

    public String getCombatStimulantsLore() {
        return Color.colorize(getString("skill.combat-stimulants.lore"));
    }

    public String getDoctorMaskLore() {
        return Color.colorize(getString("skill.doctor-mask.lore"));
    }

    public String getHealingLore() {
        return Color.colorize(getString("skill.healing.lore"));
    }

    public String getUrineTherapyLore() {
        return Color.colorize(getString("skill.urine-therapy.lore"));
    }

    public MenuItem getAlchemyItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.alchemy.item")))
                .setName(getAlchemyName())
                .setLore(getAlchemyLore());
    }

    public MenuItem getBrutalSurgeryItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.brutal-surgery.item")))
                .setName(getBrutalSurgeryName())
                .setLore(getBrutalSurgeryLore());
    }

    public MenuItem getCombatStimulantsItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.combat-stimulants.item")))
                .setName(getCombatStimulantsName())
                .setLore(getCombatStimulantsLore());
    }

    public MenuItem getDoctorMaskItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.doctor-mask.item")))
                .setName(getDoctorMaskName())
                .setLore(getDoctorMaskLore());
    }

    public MenuItem getHealingItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.healing.item")))
                .setName(getHealingName())
                .setLore(getHealingLore());
    }

    public MenuItem getUrineTherapyItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.urine-therapy.item")))
                .setName(getUrineTherapyName())
                .setLore(getUrineTherapyLore());
    }
}
