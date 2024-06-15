package dev.mega.afterrome;

import dev.mega.afterrome.api.AfterRomeAPI;
import dev.mega.afterrome.config.ConfigManager;
import dev.mega.megacore.MegaCore;
import dev.mega.megacore.util.MegaCoreUtil;
import org.bukkit.Bukkit;

import java.util.List;

/**
 * Class represents AfterRome entrypoint.
 */
public abstract class AfterRome extends MegaCore {

    public AfterRome(String managersPath, String listenersPath) {
        super(ConfigManager.class,
                List.of("dev.mega.afterrome.manager", managersPath),
                List.of("dev.mega.afterrome.listener", listenersPath));
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

        if (AfterRomeAPI.getAfterRomeImpl() == null || !AfterRomeAPI.isImplemented()) {
            MegaCoreUtil.getLogger().severe("AfterRome has no implementation! Disabling plugin...");
            Bukkit.getPluginManager().disablePlugin(this);
        }
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
