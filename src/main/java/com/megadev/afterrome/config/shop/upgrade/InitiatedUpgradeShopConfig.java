package com.megadev.afterrome.config.shop.upgrade;

import com.megadev.afterrome.object.menu.item.MenuItem;
import dev.mega.megacore.config.Configurator;
import dev.mega.megacore.util.Color;
import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class InitiatedUpgradeShopConfig extends Configurator implements UpgradeShopConfig {
    public InitiatedUpgradeShopConfig(@NotNull Plugin plugin, String... path) {
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

    public String getDaturaName() {
        return Color.getTranslated(getString("skill.datura.name"));
    }

    public String getDaturaLore() {
        return Color.getTranslated(getString("skill.datura.lore"));
    }

    public MenuItem getDaturaItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.datura.item")))
                .setName(getDaturaName())
                .setLore(getDaturaLore());
    }

    public String getLeprosyName() {
        return Color.getTranslated(getString("skill.leprosy.name"));
    }

    public String getLeprosyLore() {
        return Color.getTranslated(getString("skill.leprosy.lore"));
    }

    public MenuItem getLeprosyItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.leprosy.item")))
                .setName(getLeprosyName())
                .setLore(getLeprosyLore());
    }

    public String getParticipleName() {
        return Color.getTranslated(getString("skill.participle.name"));
    }

    public String getParticipleLore() {
        return Color.getTranslated(getString("skill.participle.lore"));
    }

    public MenuItem getParticipleItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.participle.item")))
                .setName(getParticipleName())
                .setLore(getParticipleLore());
    }

    public String getSaintFaceName() {
        return Color.getTranslated(getString("skill.saint-face.name"));
    }

    public String getSaintFaceLore() {
        return Color.getTranslated(getString("skill.saint-face.lore"));
    }

    public MenuItem getSaintFaceItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.saint-face.item")))
                .setName(getSaintFaceName())
                .setLore(getSaintFaceLore());
    }

    public String getSpiderEyeName() {
        return Color.getTranslated(getString("skill.spider-eye.name"));
    }

    public String getSpiderEyeLore() {
        return Color.getTranslated(getString("skill.spider-eye.lore"));
    }

    public MenuItem getSpiderEyeItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.spider-eye.item")))
                .setName(getSpiderEyeName())
                .setLore(getSpiderEyeLore());
    }

    public String getStartWhisperName() {
        return Color.getTranslated(getString("skill.start-whisper.name"));
    }

    public String getStartWhisperLore() {
        return Color.getTranslated(getString("skill.start-whisper.lore"));
    }

    public MenuItem getStartWhisperItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.start-whisper.item")))
                .setName(getStartWhisperName())
                .setLore(getStartWhisperLore());
    }
}
