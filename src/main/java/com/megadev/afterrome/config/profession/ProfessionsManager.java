package com.megadev.afterrome.config.profession;

import dev.mega.megacore.config.Manager;

import lombok.Getter;

import org.bukkit.plugin.Plugin;

public class ProfessionsManager extends Manager {
    @Getter private static ProfessionsManager instance;
    public ProfessionsManager(Plugin plugin, String dataFolder) {
        super(plugin, dataFolder);


    }
}