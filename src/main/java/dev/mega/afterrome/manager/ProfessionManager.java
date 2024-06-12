package dev.mega.afterrome.manager;

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

public class ProfessionManager extends Manager {
    private final List<Profession> professionListMap = new ArrayList<>();

    public ProfessionManager(MegaCore megaCore) {
        super(megaCore);
    }

    public void registerEvents(List<String> events) {
        Bukkit.getPluginManager().registerEvents(new ProfessionListener(megaCore, events), megaCore);
    }

    public boolean isAllowed(User user, Event event) {


        return false;
    }

    public void add(Profession profession) {
        professionListMap.add(profession);
    }

    public Profession getDefault() {
        if (!professionListMap.isEmpty())
            return Profession.copyOf(professionListMap.get(0));
        return Profession.of("default", new ArrayList<>());
    }

    @Override
    public void enable() {
        professionListMap.addAll(Parser.getProfessions());
    }

    @Override
    public void disable() {

    }
}
