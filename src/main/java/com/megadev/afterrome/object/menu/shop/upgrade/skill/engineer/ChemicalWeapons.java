package com.megadev.afterrome.object.menu.shop.upgrade.skill.engineer;

import com.megadev.afterrome.config.shop.upgrade.EngineerUpgradeShopConfig;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import lombok.Getter;

@Getter
public class ChemicalWeapons implements Skill {
    private final MenuItem menuItem;

    public ChemicalWeapons() {
        menuItem = ConfigManager.getInstance().getConfig(EngineerUpgradeShopConfig.class).getChemicalWeaponsItem();
    }
}
