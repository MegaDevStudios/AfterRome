package com.megadev.afterrome.config.user;

import com.google.common.collect.Maps;
import com.megadev.afterrome.object.profession.DefaultProfession;
import dev.mega.megacore.MegaCore;
import dev.mega.megacore.config.Configurator;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.UUID;

public class UserConfig extends Configurator {
    protected UserConfig(@NotNull Plugin plugin, String... path) {
        super(plugin, path);
    }

    public void saveData(Map<String, Object> args) {
        for (Map.Entry<String, Object> arg : args.entrySet()) {
            String key = arg.getKey();
            Object value = arg.getValue();

            setValue(key, value);
        }
    }

    public Map<String, Object> getData() {
        Map<String, Object> data = Maps.newConcurrentMap();

        if (config.get("user") != null) {
            data.put("uuid", config.get("user.uuid"));
            data.put("profession", config.get("user.profession"));
            data.put("healths", config.get("user.healths"));
            data.put("points", config.get("user.points"));
            return data;
        } else {
            data.put("uuid", UUID.fromString(config.getName().replace(".yml", "")));
            data.put("profession", new DefaultProfession());
            data.put("healths", 3);
            data.put("points", 0);
        }

        return data;
    }
}
