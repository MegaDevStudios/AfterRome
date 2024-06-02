package dev.mega.afterrome;

import com.megadev.afterrome.config.ConfigManager;
import dev.mega.afterrome.manager.AfterRomeManager;
import dev.mega.megacore.MegaCore;

public class AfterRome extends MegaCore {
    public AfterRome() {
        super(ConfigManager.getInstance(), "");
    }

    @Override
    public void enable() {
        AfterRomeManager.init(this).enable();
    }

    @Override
    public void disable() {
        AfterRomeManager.getInstance().disable();
    }
}
