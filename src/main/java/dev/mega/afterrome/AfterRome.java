package dev.mega.afterrome;

import dev.mega.afterrome.api.AfterRomeAPI;
import dev.mega.afterrome.config.ConfigManager;
import dev.mega.megacore.MegaCore;
import dev.mega.megacore.util.MegaCoreUtil;
import org.bukkit.Bukkit;

/**
 * Class represents AfterRome entrypoint.
 */
public abstract class AfterRome extends MegaCore {

    public AfterRome() {
        super(ConfigManager.class,
                "dev.mega.afterrome.manager",
                "dev.mega.afterrome.listener");
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
