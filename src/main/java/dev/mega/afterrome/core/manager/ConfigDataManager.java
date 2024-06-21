package dev.mega.afterrome.core.manager;

import dev.mega.afterrome.core.config.data.ConfigData;
import dev.mega.megacore.MegaCore;
import dev.mega.megacore.config.serializer.JsonSerializer;
import dev.mega.megacore.manager.Manager;
import dev.mega.megacore.manager.priority.ManagerPriority;
import dev.mega.megacore.manager.priority.Priority;
import lombok.Getter;

import java.io.File;

@ManagerPriority(priority = Priority.HIGH)
public class ConfigDataManager extends Manager {
    private final String dataFolder = megaCore.getDataFolder().getAbsolutePath() + File.separator + "xdev/";
    @Getter
    private ConfigData configData;

    public ConfigDataManager(MegaCore megaCore) {
        super(megaCore);
    }

    @Override
    public void enable() {
        configData = (ConfigData) JsonSerializer.deserialize(
                new File(dataFolder + File.separator + "professions.json"), ConfigData.class);
    }

    @Override
    public void disable() {

    }
}
