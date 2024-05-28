package com.megadev.afterrome.object.profession;

import com.megadev.afterrome.config.profession.EngineerConfig;
import com.megadev.afterrome.object.menu.AbstractUpgradeMenu;
import com.megadev.afterrome.object.menu.shop.upgrade.menu.EngineerMenu;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.object.user.User;
import dev.mega.megacore.config.Configurator;

import java.util.List;

public class Engineer extends Profession<EngineerConfig, EngineerMenu> {
    protected Engineer(Class<EngineerConfig> configClass, Class<EngineerMenu> menuClass) {
        super(configClass, menuClass);
    }

    @Override
    public String getNameOfProfession() {
        return "";
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
