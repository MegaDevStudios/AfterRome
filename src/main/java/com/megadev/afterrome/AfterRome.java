package com.megadev.afterrome;

import com.megadev.afterrome.config.ConfigManager;

import dev.mega.megacore.MegaCore;

public final class AfterRome extends MegaCore {

    @Override
    public void enable() {
        setupManagers();
    }

    @Override
    public void disable() {

    }

    private void setupManagers() {
        ConfigManager.init(this);
    }
}
