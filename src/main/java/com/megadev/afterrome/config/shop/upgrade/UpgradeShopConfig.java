package com.megadev.afterrome.config.shop.upgrade;

import com.megadev.afterrome.config.Configurable;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import java.util.List;

public interface UpgradeShopConfig {
    String getMenuName();

    List<Skill> getSkills();

    MenuItem getBackgroundItem();
}
