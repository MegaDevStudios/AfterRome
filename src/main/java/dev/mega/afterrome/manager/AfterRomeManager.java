package dev.mega.afterrome.manager;

import dev.mega.megacore.MegaCore;
import dev.mega.megacore.manager.Manager;
import dev.mega.megacore.util.ClassUtil;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Getter
public class AfterRomeManager extends Manager {
    @Getter private static AfterRomeManager instance;
    private final Map<String, Manager> managers = new HashMap<>();

    private AfterRomeManager(MegaCore megaCore) {
        super(megaCore);
    }

    public static AfterRomeManager init(MegaCore megaCore) {
        if (instance == null) {
            instance = new AfterRomeManager(megaCore);
        }
        return getInstance();
    }

    private void registerManagers() {
        Set<Class<?>> managerClasses = ClassUtil.findSubclasses("dev.mega.myplugin.manager.module", Manager.class);
        for (Class<?> managerClass : managerClasses) {
            try {
                Manager manager = (Manager) managerClass.getDeclaredConstructor(MegaCore.class).newInstance(megaCore);
                managers.put(managerClass.getSimpleName(), manager);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void enable() {
        registerManagers();
        for (Manager manager : managers.values()) {
            manager.enable();
        }
        setRunning(true);
    }

    @Override
    public void disable() {
        for (Manager manager : managers.values()) {
            manager.disable();
        }
        setRunning(false);
    }
}
