package com.megadev.afterrome.config.shop.upgrade;

import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.aesculapius.*;
import com.megadev.afterrome.util.Color;

import dev.mega.megacore.config.Configurator;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class AesculapiusUpgradeShopConfig extends Configurator implements UpgradeShopConfig {
    private final List<Skill> skills = new ArrayList<>();

    public AesculapiusUpgradeShopConfig(@NotNull Plugin plugin, String... path) {
        super(plugin, path);
        skills.addAll(List.of(
                new Alchemy(),
                new BrutalSurgery(),
                new CombatStimulants(),
                new DoctorMask(),
                new Healing(),
                new UrineTherapy()
        ));
    }

    @Override
    public String getMenuName() {
        return Color.colorize(getString("menu-name"));
    }

    @Override
    public MenuItem getBackgroundItem() {
        return new MenuItem(Material.valueOf(getString("background-item"))).setName("&f");
    }
}
