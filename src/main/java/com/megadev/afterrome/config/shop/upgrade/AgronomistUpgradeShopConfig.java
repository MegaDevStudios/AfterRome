package com.megadev.afterrome.config.shop.upgrade;

import com.megadev.afterrome.manager.UserManager;
import com.megadev.afterrome.object.menu.action.ClickAction;
import com.megadev.afterrome.object.menu.item.MenuItem;

import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.SkillType;
import com.megadev.afterrome.object.user.User;
import dev.mega.megacore.config.Configurator;

import dev.mega.megacore.util.Color;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AgronomistUpgradeShopConfig extends Configurator implements UpgradeShopConfig {
    public AgronomistUpgradeShopConfig(@NotNull Plugin plugin, String... path) {
        super(plugin, path);
    }

    @Override
    public String getMenuName() {
        return Color.getTranslated(getString("menu-name"));
    }

    @Override
    public MenuItem getBackgroundItem() {
        return new MenuItem(Material.valueOf(getString("background-item"))).setName("&f");
    }

    public String getButcherName() {
        return Color.getTranslated(getString("skill.butcher.name"));
    }

    public String getCookName() {
        return Color.getTranslated(getString("skill.cook.name"));
    }

    public String getFarmerName() {
        return Color.getTranslated(getString("skill.farmer.name"));
    }

    public String getHatcherName() {
        return Color.getTranslated(getString("skill.hatcher.name"));
    }

    public String getLumberjackName() {
        return Color.getTranslated(getString("skill.lumberjack.name"));
    }

    public String getTannerName() {
        return Color.getTranslated(getString("skill.tanner.name"));
    }

    public String getButcherLore() {
        return Color.getTranslated(getString("skill.butcher.lore"));
    }

    public String getCookLore() {
        return Color.getTranslated(getString("skill.cook.lore"));
    }

    public String getFarmerLore() {
        return Color.getTranslated(getString("skill.farmer.lore"));
    }

    public String getHatcherLore() {
        return Color.getTranslated(getString("skill.hatcher.lore"));
    }

    public String getLumberjackLore() {
        return Color.getTranslated(getString("skill.lumberjack.lore"));
    }

    public String getTannerLore() {
        return Color.getTranslated(getString("skill.tanner.lore"));
    }

    public MenuItem getButcherItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.butcher.item")))
                .setName(getButcherName())
                .setLore(getButcherLore())
                .addClickAction(event -> setAction(event, SkillType.BUTCHER));
    }

    public MenuItem getCookItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.cook.item")))
                .setName(getCookName())
                .setLore(getCookLore())
                .addClickAction(event -> setAction(event, SkillType.COOK));
    }

    public MenuItem getFarmerItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.farmer.item")))
                .setName(getFarmerName())
                .setLore(getFarmerLore())
                .addClickAction(event -> setAction(event, SkillType.FARMER));
    }

    public MenuItem getHatcherItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.hatcher.item")))
                .setName(getHatcherName())
                .setLore(getHatcherLore())
                .addClickAction(event -> setAction(event, SkillType.HATCHER));
    }
    public MenuItem getLumberjackItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.lumberjack.item")))
                .setName(getLumberjackName())
                .setLore(getLumberjackLore())
                .addClickAction(event -> setAction(event, SkillType.LUMBERJACK));
    }

    public MenuItem getTannerItem() {
        return new MenuItem(
                Material.valueOf(getString("skill.tanner.item")))
                .setName(getTannerName())
                .setLore(getTannerLore())
                .addClickAction(event -> setAction(event, SkillType.TANNER));
    }

    private void setAction(InventoryClickEvent event, SkillType skillType) {
        List<HumanEntity> viewers = event.getViewers();
        if (viewers.isEmpty()) return;
        User user = UserManager.getInstance().getUser((Player) viewers.get(0));

        if (user.subtractPoints()) {
            user.getProfession().getSkill(skillType).incrementLevel();
        } else {
            user.sendMessage("&cУ вас не получилось прокачать навык");
        }

    }
}
