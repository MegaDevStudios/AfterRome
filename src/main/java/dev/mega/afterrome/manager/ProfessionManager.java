package dev.mega.afterrome.manager;

import dev.mega.afterrome.listener.ProfessionListener;
import dev.mega.afterrome.parser.Parser;
import dev.mega.afterrome.user.Profession;
import dev.mega.megacore.MegaCore;
import dev.mega.megacore.manager.Manager;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
     * @return default profession.
     */
    public Profession getDefault() {
        if (!professionListMap.isEmpty())
            return Profession.copyOf(professionListMap.get(0));
        return Profession.of("default", new ArrayList<>());
    }

    /**
     * Gets profession by name.
     * @return profession.
     */
    public Profession getProfession(String professionName) {
        Optional<Profession> optionalProfession = professionListMap
                .stream()
                .filter(profession -> professionName.equals(profession.getName()))
                .findAny();

        return optionalProfession.orElseGet(() -> Profession.copyOf(professionListMap.get(0)));
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
