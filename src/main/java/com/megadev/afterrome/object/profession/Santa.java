package com.megadev.afterrome.object.profession;

import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.config.shop.sale.AgronomistSaleConfig;
import com.megadev.afterrome.config.shop.sale.SaleConfig;
import com.megadev.afterrome.object.menu.AbstractUpgradeMenu;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.SkillType;
import com.megadev.afterrome.object.user.User;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public class Santa implements HiddenProfession {
    @Override
    public String getName() {
        return "";
    }

    @Override
    public ProfessionType getProfessionType() {
        return null;
    }

    @Override
    public AbstractUpgradeMenu getUpgradeMenu(User user) {
        return null;
    }

    @Override
    public MenuItem getBackgroundItem() {
        return null;
    }

    @Override
    public List<Skill> getSkills() {
        return List.of();
    }

    @Override
    public Skill getSkill(SkillType skill) {
        return null;
    }

    @Override
    public Profession deserialize(Map<String, Object> data) {
        return null;
    }

    @Override
    public SaleConfig getSaleConfig() {
        return ConfigManager.getInstance().getConfig(AgronomistSaleConfig.class);
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        return Map.of();
    }
}
