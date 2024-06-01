package com.megadev.afterrome.config;

import dev.mega.megacore.config.Configurator;
import dev.mega.megacore.util.Color;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class MainConfig extends Configurator {
    public MainConfig(@NotNull Plugin plugin, String... path) {
        super(plugin, path);
    }

    public String getChoiceMenuName() {
        return Color.getTranslated(getString("menu.choice-menu.name"));
    }

    public String getAgronomistLore() {
        return Color.getTranslated(getString("menu.choice-menu.head.agronomist.lore"));
    }

    public String getArtisanLore() {
        return Color.getTranslated(getString("menu.choice-menu.head.artisan.lore"));
    }

    public String getAesculapiusLore() {
        return Color.getTranslated(getString("menu.choice-menu.head.aesculapius.lore"));
    }

    public String getForesterLore() {
        return Color.getTranslated(getString("menu.choice-menu.head.forester.lore"));
    }

    public String getSonOfMarsLore() {
        return Color.getTranslated(getString("menu.choice-menu.head.son-of-mars.lore"));
    }


    public String getAgronomistName() {
        return Color.getTranslated(getString("menu.choice-menu.head.agronomist.name"));
    }

    public String getSonOfMarsName() {
        return Color.getTranslated(getString("menu.choice-menu.head.son-of-mars.name"));
    }

    public String getArtisanName() {
        return Color.getTranslated(getString("menu.choice-menu.head.artisan.name"));
    }

    public String getAesculapiusName() {
        return Color.getTranslated(getString("menu.choice-menu.head.aesculapius.name"));
    }

    public String getForesterName() {
        return Color.getTranslated(getString("menu.choice-menu.head.forester.name"));
    }

    public String getAgronomistTexture() {
        return getString("menu.choice-menu.head.agronomist.texture");
    }

    public String getArtisanTexture() {
        return getString("menu.choice-menu.head.artisan.texture");
    }

    public String getAesculapiusTexture() {
        return getString("menu.choice-menu.head.aesculapius.texture");
    }

    public String getForesterTexture() {
        return getString("menu.choice-menu.head.forester.texture");
    }

    public String getSonOfMarsTexture() {
        return getString("menu.choice-menu.head.son-of-mars.texture");
    }

    public int getMaxUnitsPerPoint() {
        return getValue("player.max-units-per-points");
    }

    @Override
    public @NotNull String saveToString() {
        return "";
    }

    @Override
    public void loadFromString(@NotNull String s) throws InvalidConfigurationException {

    }
}
