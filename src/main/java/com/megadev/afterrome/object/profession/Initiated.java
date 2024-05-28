package com.megadev.afterrome.object.profession;

import com.megadev.afterrome.config.profession.InitiatedConfig;
import com.megadev.afterrome.object.menu.AbstractUpgradeMenu;
import com.megadev.afterrome.object.menu.shop.upgrade.menu.InitiatedMenu;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.object.user.User;
import dev.mega.megacore.config.Configurator;

import java.util.List;

public class Initiated extends Profession<InitiatedConfig, InitiatedMenu> {
    protected Initiated(Class<InitiatedConfig> configClass, Class<InitiatedMenu> menuClass) {
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
