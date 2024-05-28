package com.megadev.afterrome.object.profession;

import com.megadev.afterrome.config.profession.ArtisanConfig;
import com.megadev.afterrome.object.menu.AbstractUpgradeMenu;
import com.megadev.afterrome.object.menu.shop.upgrade.menu.ArtisanMenu;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.object.user.User;
import dev.mega.megacore.config.Configurator;

import java.util.List;

public class Artisan extends Profession<ArtisanConfig, ArtisanMenu> {
    protected Artisan(Class<ArtisanConfig> configClass, Class<ArtisanMenu> menuClass) {
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
