package dev.mega.afterrome;

import com.megadev.afterrome.config.ConfigManager;
import dev.mega.megacore.MegaCore;

public class AfterRome extends MegaCore {
    public AfterRome() {
        super(ConfigManager.class,
                "dev.mega.afterrome.manager", "dev.mega.afterrome.listener");
    }

    @Override
    protected void registerCommands() {

    }

    @Override
    public void enable() {

    }

    @Override
    public void disable() {

    }
}
