package com.megadev.afterrome.config.shop.upgrade;

import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.util.Color;
import dev.mega.megacore.config.Configurator;
import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class InitiatedUpgradeShopConfig extends Configurator implements UpgradeShopConfig {
    public InitiatedUpgradeShopConfig(@NotNull Plugin plugin, String... path) {
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

    public String getDaturaName() {
        return Color.colorize(getString("skill.datura.name"));
    }

    public String getDaturaLore() {
        return Color.colorize(getString("skill.datura.lore"));
    }

    public MenuItem getDaturaItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.datura.item")))
                .setName(getDaturaName())
                .setLore(getDaturaLore());
    }

    public String getLeprosyName() {
        return Color.colorize(getString("skill.leprosy.name"));
    }

    public String getLeprosyLore() {
        return Color.colorize(getString("skill.leprosy.lore"));
    }

    public MenuItem getLeprosyItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.leprosy.item")))
                .setName(getLeprosyName())
                .setLore(getLeprosyLore());
    }

    public String getParticipleName() {
        return Color.colorize(getString("skill.participle.name"));
    }

    public String getParticipleLore() {
        return Color.colorize(getString("skill.participle.lore"));
    }

    public MenuItem getParticipleItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.participle.item")))
                .setName(getParticipleName())
                .setLore(getParticipleLore());
    }

    public String getSaintFaceName() {
        return Color.colorize(getString("skill.saint-face.name"));
    }

    public String getSaintFaceLore() {
        return Color.colorize(getString("skill.saint-face.lore"));
    }

    public MenuItem getSaintFaceItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.saint-face.item")))
                .setName(getSaintFaceName())
                .setLore(getSaintFaceLore());
    }

    public String getSpiderEyeName() {
        return Color.colorize(getString("skill.spider-eye.name"));
    }

    public String getSpiderEyeLore() {
        return Color.colorize(getString("skill.spider-eye.lore"));
    }

    public MenuItem getSpiderEyeItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.spider-eye.item")))
                .setName(getSpiderEyeName())
                .setLore(getSpiderEyeLore());
    }

    public String getStartWhisperName() {
        return Color.colorize(getString("skill.start-whisper.name"));
    }

    public String getStartWhisperLore() {
        return Color.colorize(getString("skill.start-whisper.lore"));
    }

    public MenuItem getStartWhisperItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.start-whisper.item")))
                .setName(getStartWhisperName())
                .setLore(getStartWhisperLore());
    }
}
