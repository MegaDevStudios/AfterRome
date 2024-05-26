package com.megadev.afterrome.config.shop.upgrade;

import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.util.Color;
import dev.mega.megacore.config.Configurator;
import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EngineerUpgradeShopConfig extends Configurator implements UpgradeShopConfig {
    public EngineerUpgradeShopConfig(@NotNull Plugin plugin, String... path) {
        super(plugin, path);
    }

    @Override
    public String getMenuName() {
        return Color.colorize(getString("menu-name"));
    }

    @Override
    public List<Skill> getSkills() {
        return List.of();
    }

    @Override
    public MenuItem getBackgroundItem() {
        return new MenuItem(Material.valueOf(getString("background-item"))).setName("&f");
    }

}
