package com.megadev.afterrome.object.profession;

import com.megadev.afterrome.config.profession.AesculapiusConfig;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.object.menu.AbstractUpgradeMenu;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.menu.AesculapiusMenu;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.object.user.User;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public class Aesculapius implements Profession {
    List<Skill> skills;

    @Override
    public String getNameOfProfession() {
        return ConfigManager.getInstance().getConfig(AesculapiusConfig.class).getName();
    }

    @Override
    public AbstractUpgradeMenu getUpgradeMenu(User user) {
        return new AesculapiusMenu(user, this);
    }

    @Override
    public MenuItem getBackgroundItem() {
        return null;
    }

    @Override
    public List<Skill> getSkills() {
        return List.of();
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        return Map.of();
    }
}
