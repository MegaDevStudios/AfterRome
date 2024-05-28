package com.megadev.afterrome.object.profession;

import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.config.Configurable;
import com.megadev.afterrome.config.profession.AgronomistConfig;
import com.megadev.afterrome.config.profession.ProfessionConfig;
import com.megadev.afterrome.object.menu. AbstractUpgradeMenu;
import com.megadev.afterrome.object.menu.shop.upgrade.menu.AesculapiusMenu;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.object.user.User;
import dev.mega.megacore.config.Config;
import dev.mega.megacore.config.Configurator;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public abstract class Profession<T extends Config, K extends AbstractUpgradeMenu> {
    private final Class<T> configClass;
    private final Class<K> menuClass;

    protected Profession(Class<T> configClass, Class<K> menuClass) {
        this.configClass = configClass;
        this.menuClass = menuClass;
    }

    public String getNameOfProfession() {
        return ((ProfessionConfig) ConfigManager.getInstance().getConfig(configClass)).getName();
    }

    public AbstractUpgradeMenu getUpgradeMenu(User user) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return menuClass.getConstructor().newInstance();
    }

    abstract boolean isHidden();

    abstract List<Skill> getSkills();
}
