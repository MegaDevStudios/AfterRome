package com.megadev.afterrome.object.menu.shop.upgrade.skill.engineer;

import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import lombok.Getter;

public class ChemicalWeapons implements Skill {
    @Getter
    private MenuItem menuItem;

    @Override
    public String getTitle() {
        return "";
    }

    @Override
    public String getLore() {
        return "";
    }
}
