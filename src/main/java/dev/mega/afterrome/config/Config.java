package dev.mega.afterrome.config;

import dev.mega.afterrome.user.Profession;
import dev.mega.afterrome.user.Skill;
import dev.mega.megacore.config.Configurator;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Config extends Configurator {
    protected Config(@NotNull Plugin plugin, String... path) {
        super(plugin, path);
    }

    public List<Skill.Type> getSkillsOf(Profession.Type type) {
        return config.getStringList("profession-skill."+type).stream().map(Skill.Type::valueOf).toList();
    }
}
