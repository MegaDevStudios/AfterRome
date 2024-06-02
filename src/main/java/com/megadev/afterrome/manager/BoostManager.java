package com.megadev.afterrome.manager;

import com.megadev.afterrome.object.skill.boost.Boost;
import dev.mega.megacore.MegaCore;
import dev.mega.megacore.manager.Manager;

public class BoostManager extends Manager {
    private static BoostManager instance;

    private BoostManager(MegaCore megaCore) {
        super(megaCore);
    }

    public static void init(MegaCore megaCore) {
        if (instance == null) {
            instance = new BoostManager(megaCore);
        }
    }

    public void executeBoost(Boost boost) {

    }

    @Override
    public void enable() {

    }

    @Override
    public void disable() {

    }
}
