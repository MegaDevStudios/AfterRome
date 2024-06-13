package dev.mega.afterrome.manager;

import dev.mega.afterrome.config.data.execute.ExecuteSection;
import dev.mega.afterrome.listener.ProfessionListener;
import dev.mega.afterrome.parser.Parser;
import dev.mega.afterrome.user.Profession;
import dev.mega.afterrome.user.User;
import dev.mega.megacore.MegaCore;
import dev.mega.megacore.manager.Manager;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Class represents the manager to manage profession events.
 */
public class ProfessionManager extends Manager {
    private final List<Profession> professionListMap = new ArrayList<>();

    public ProfessionManager(MegaCore megaCore) {
        super(megaCore);
    }

    /**
     * Registers the listener for professions events.
     * @param events
     */
    public void registerEvents(List<String> events) {
        Bukkit.getPluginManager().registerEvents(new ProfessionListener(megaCore, events), megaCore);
    }

    /**
     * Adds the profession to list.
     * @param profession
     */
    public void add(Profession profession) {
        professionListMap.add(profession);
    }

    /**
     * Gets cloned default profession.
     * @return
     */
    public Profession getDefault() {
        if (!professionListMap.isEmpty())
            return Profession.copyOf(professionListMap.get(0));
        return Profession.of("default", new ArrayList<>());
    }

    /**
     * Calls when manager enables.
     */
    @Override
    public void enable() {
        professionListMap.addAll(Parser.getInstance().getProfessions());
    }

    /**
     * Calls when manager disables.
     */
    @Override
    public void disable() {

    }
}
