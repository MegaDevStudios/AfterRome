package com.megadev.afterrome.object.menu.shop.upgrade.menu;

import com.megadev.afterrome.object.menu.Menu;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MafiaMenu implements Menu {
    private final List<Skill> skills = new ArrayList<>();
    private Inventory inventory;

    @NotNull
    @Override
    public Inventory getInventory() {
        return null;
    }
}
