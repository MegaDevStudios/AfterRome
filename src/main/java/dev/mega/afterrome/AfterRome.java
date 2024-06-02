package dev.mega.afterrome;

import com.megadev.afterrome.config.ConfigManager;
import dev.mega.afterrome.manager.AfterRomeManager;
import dev.mega.megacore.MegaCore;

import java.lang.reflect.InvocationTargetException;

public class AfterRome extends MegaCore {
    public AfterRome() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        super(ConfigManager.class, "");
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
