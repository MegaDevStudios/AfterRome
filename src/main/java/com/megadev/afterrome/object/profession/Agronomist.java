package com.megadev.afterrome.object.profession;

import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.config.profession.AgronomistConfig;
import com.megadev.afterrome.object.menu.AbstractUpgradeMenu;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.menu.AgronomistMenu;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.agronomist.*;
import com.megadev.afterrome.object.user.User;
import lombok.Getter;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

@Getter
public class Agronomist implements Profession {
    List<Skill> skills;

    public Agronomist() {
       skills = List.of(
               new Butcher(),
               new Cook(),
               new Farmer(),
               new Hatcher(),
               new Lumberjack(),
               new Tanner()
       );
    }

    @Override
    public String getNameOfProfession() {
        return ConfigManager.getInstance().getConfig(AgronomistConfig.class).getName();
    }

    @Override
    public AbstractUpgradeMenu getUpgradeMenu(User user) {
        return new AgronomistMenu(user, getSkills());
    }

    @Override
    public MenuItem getBackgroundItem() {
        return new MenuItem(Material.valueOf(ConfigManager.getInstance().getConfig()));
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        return Map.of("skills", skills);
    }
}
