package com.megadev.afterrome.object.profession;

import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.config.manager.ProfessionsManager;
import com.megadev.afterrome.config.manager.ShopManager;
import com.megadev.afterrome.config.profession.AgronomistConfig;
import com.megadev.afterrome.config.shop.upgrade.AgronomistUpgradeShopConfig;
import com.megadev.afterrome.object.menu.AbstractUpgradeMenu;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.menu.AgronomistMenu;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.SkillType;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.agronomist.*;
import com.megadev.afterrome.object.user.User;
import lombok.Getter;

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
    public Skill getSkill(SkillType agronomistSkill) {
        return switch (agronomistSkill) {
            case BUTCHER -> skills.get(0);
            case COOK -> skills.get(1);
            case FARMER -> skills.get(2);
            case HATCHER -> skills.get(3);
            case LUMBERJACK -> skills.get(4);
            case TANNER -> skills.get(5);
        };
    }



    @Override
    public String getNameOfProfession() {
        ProfessionsManager shopManager = ConfigManager.getInstance().getManager(ProfessionsManager.class);
        return shopManager.getConfig(AgronomistConfig.class).getName();
    }

    @Override
    public AbstractUpgradeMenu getUpgradeMenu(User user) {
        return new AgronomistMenu(user, this);
    }

    @Override
    public MenuItem getBackgroundItem() {
        ShopManager shopManager = ConfigManager.getInstance().getManager(ShopManager.class);
        return shopManager.getConfig(AgronomistUpgradeShopConfig.class).getBackgroundItem();
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        return Map.of("skills", skills);
    }
}
