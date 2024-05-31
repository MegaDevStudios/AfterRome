package com.megadev.afterrome.config.user;

import com.google.common.collect.Maps;
import dev.mega.megacore.MegaCore;
import dev.mega.megacore.config.Configurator;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

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
      data.put("uuid", config.get("user.uuid"));
        data.put("profession", config.get("user.profession"));
        data.put("healths", config.get("user.healths"));
        data.put("points", config.get("user.points"));
        return data;
    }
}
