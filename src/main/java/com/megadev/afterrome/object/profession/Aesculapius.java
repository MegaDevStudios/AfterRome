package com.megadev.afterrome.object.profession;

import com.megadev.afterrome.config.profession.AesculapiusConfig;
import com.megadev.afterrome.config.shop.upgrade.AesculapiusUpgradeShopConfig;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.object.menu.AbstractUpgradeMenu;
import com.megadev.afterrome.object.menu.shop.upgrade.menu.AesculapiusMenu;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.object.user.User;

import java.util.List;

public class Aesculapius extends Profession<AesculapiusConfig, AesculapiusMenu> {

    protected Aesculapius(Class<AesculapiusConfig> configClass, Class<AesculapiusMenu> menuClass) {
        super(configClass, menuClass);
    }

    @Override
    public String getNameOfProfession() {
        return ConfigManager.getInstance().getConfig(AesculapiusConfig.class).getName();
    }

    @Override
    public AbstractUpgradeMenu getUpgradeMenu(User user) {
        return new AesculapiusMenu(user, getSkills());
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
