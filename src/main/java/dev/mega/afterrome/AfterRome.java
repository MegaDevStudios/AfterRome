package dev.mega.afterrome;

import dev.mega.afterrome.api.AfterRomeAPI;
import dev.mega.afterrome.api.ArAPIHandler;
import dev.mega.afterrome.config.ConfigManager;
import dev.mega.megacore.MegaCore;

public class AfterRome extends MegaCore {
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
        AfterRomeAPI.setApi(new ArAPIHandler());
    }

    @Override
    public void disable() {

    }
}
