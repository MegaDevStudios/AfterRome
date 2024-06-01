package com.megadev.afterrome.manager;

import com.megadev.afterrome.object.menu.AbstractMenu;
import com.megadev.afterrome.object.user.User;

import com.megadev.afterrome.storage.RefreshingData;
import dev.mega.megacore.MegaCore;
import dev.mega.megacore.manager.Manager;
import dev.mega.megacore.util.Color;
import lombok.Getter;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;

@Getter
public class MenuManager extends Manager {
    @Getter private static MenuManager instance;
    @Getter private final static HashMap<User, BukkitTask> refreshingMenus = new HashMap<>();
    private RefreshingData refreshingData;

    private MenuManager(MegaCore megaCore) {
        super(megaCore);
    }

    public static void init(MegaCore megaCore) {
        if (instance == null) {
            instance = new MenuManager(megaCore);
        }
    }

    public void putTaskForUser(User user, AbstractMenu menu) {
        refreshingData.addValue(user.getUuid(), Bukkit.getScheduler().runTaskTimer(this.megaCore, () -> {
            if (!menu.getUser().getPlayer().getOpenInventory().title().equals(Component.text(Color.getTranslated(menu.getMenuName())))) {
                cancelTaskForUser(user);
                removeTaskForUser(user);
                return;
            }
            menu.update();
        }, menu.updateTime(), menu.updateTime()));
    }

    public void removeTaskForUser(User user) {
        refreshingData.remove(user.getUuid());
    }

    public void cancelTaskForUser(User user) {
        refreshingData.getValue(user.getUuid()).cancel();
    }

    public boolean containsTaskForUser(User user) {
        return refreshingData.contains(user.getUuid());
    }

    @Override
    public void reload() {
        refreshingData = new RefreshingData();
    }

    @Override
    public void enable() {

    }

    @Override
    public void disable() {
        refreshingData = null;
    }
}
