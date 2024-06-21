package dev.mega.afterrome.core;

import dev.mega.afterrome.core.api.AfterRomeAPI;
import dev.mega.afterrome.core.config.ConfigManager;
import dev.mega.afterrome.core.listener.JoinListener;
import dev.mega.megacore.MegaCore;
import dev.mega.megacore.util.MegaCoreUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import java.util.List;

/**
 * Class represents AfterRome entrypoint.
 */
public abstract class AfterRome extends MegaCore {

    public AfterRome(String managersPath, String listenersPath) {
        super(ConfigManager.class,
                List.of("dev.mega.afterrome.core.manager", managersPath),
                List.of("dev.mega.afterrome.core.listener", listenersPath));
    }

    @Override
    protected void registerCommands() {
    }

    /**
     * Calls on plugin enable.
     */
    @Override
    public void enable() {
        enableImpl();

        if (!AfterRomeAPI.isImplemented() || AfterRomeAPI.getAfterRomeImpl() == null) {
            MegaCoreUtil.getLogger().severe("AfterRome has no implementation! Disabling plugin...");
            Bukkit.getPluginManager().disablePlugin(this);
        }

        registerListeners();
    }

    private void registerListeners() {
        final PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinListener(this), this);
    }

    /**
     * Calls when plugin disables.
     */
    @Override
    public void disable() {
        disableImpl();
    }

    protected abstract void enableImpl();

    protected abstract void disableImpl();
}
