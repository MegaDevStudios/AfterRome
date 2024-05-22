package com.megadev.afterrome.object.menu.shop.upgrade.skill.initiated;

import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import lombok.Getter;

public class Participle implements Skill {
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
