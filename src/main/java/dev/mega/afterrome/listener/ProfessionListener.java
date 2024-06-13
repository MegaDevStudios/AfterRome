package dev.mega.afterrome.listener;

import dev.mega.megacore.MegaCore;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.List;

public class ProfessionListener implements Listener {
    private final List<String> eventNames;

    private final MegaCore megaCore;

    public ProfessionListener(MegaCore megaCore, List<String> eventNames) {
        this.eventNames = eventNames;
        this.megaCore = megaCore;
    }

    @EventHandler
    public boolean onEvent(BlockBreakEvent event) {
        System.out.println("Started");

        for (String eventName : eventNames) {
            String[] names = event.getClass().getName().split("\\.");
            String finalEventName = names[names.length - 1];
            if (!finalEventName.equals(eventName)) continue;

            //todo какая то логика
            System.out.println("This happened");

            return true;
        }
        return false;
    }
}
