package com.megadev.afterrome.object.shop.menu;

import com.megadev.afterrome.object.menu.UpgradeMenu;
import com.megadev.afterrome.object.shop.skill.Skill;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MafiaMenu implements UpgradeMenu {
    private final List<Skill> skills = new ArrayList<>();
    private Inventory inventory;

    @NotNull
    @Override
    public Inventory getInventory() {
        return null;
    }
}
