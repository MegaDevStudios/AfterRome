package dev.mega.afterrome;

import dev.mega.afterrome.api.AfterRomeAPI;
import dev.mega.afterrome.config.ConfigManager;
import dev.mega.megacore.MegaCore;
import dev.mega.megacore.util.MegaCoreUtil;
import org.bukkit.Bukkit;

public abstract class AfterRome extends MegaCore {
    public AfterRome() {
        super(ConfigManager.class,
                "dev.mega.afterrome.manager",
                "dev.mega.afterrome.listener");
    }

    @Override
    protected void registerCommands() {
    }

    @Override
    public void enable() {
        enableImpl();

        if (AfterRomeAPI.getAfterRomeImpl() == null || !AfterRomeAPI.isImplemented()) {
            MegaCoreUtil.getLogger().severe("AfterRome has no implementation! Disabling plugin...");
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void disable() {
        disableImpl();
    }

    protected abstract void enableImpl();

    protected abstract void disableImpl();
}
