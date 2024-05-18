package com.megadev.afterrome;

import com.megadev.afterrome.manager.ConfigManager;

import com.megadev.afterrome.manager.MenuManager;
import com.megadev.afterrome.manager.UserManager;

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
        MenuManager.init(this);
        UserManager.init(this);
    }
}
