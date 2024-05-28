package com.megadev.afterrome.object.profession;

import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.config.profession.AesculapiusConfig;
import com.megadev.afterrome.config.profession.AgronomistConfig;
import com.megadev.afterrome.object.menu.AbstractUpgradeMenu;
import com.megadev.afterrome.object.menu.shop.upgrade.menu.AgronomistMenu;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.object.user.User;
import dev.mega.megacore.config.Configurator;

import java.util.List;

public class Agronomist extends Profession<AgronomistConfig, AgronomistMenu> {
    public Agronomist(Class<AgronomistConfig> configClass, Class<AgronomistMenu> menuClass) {
        super(configClass, menuClass);
    }

    @Override
    public AbstractUpgradeMenu getUpgradeMenu(User user) {
        return null;
    }

    @Override
    public boolean isHidden() {
        return false;
    }

    @Override
    public List<Skill> getSkills() {
        return List.of();
    }

}
