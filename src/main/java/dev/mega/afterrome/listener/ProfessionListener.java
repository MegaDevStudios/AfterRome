package dev.mega.afterrome.listener;

import dev.mega.afterrome.api.AfterRomeAPI;
import dev.mega.afterrome.manager.EventManager;
import dev.mega.afterrome.user.User;
import dev.mega.megacore.MegaCore;
import dev.mega.megacore.manager.MegaManager;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProfessionListener implements Listener {
    private final List<String> eventNames;

    private final MegaCore megaCore;

    public ProfessionListener(MegaCore megaCore, List<String> eventNames) {
        this.eventNames = eventNames;
        this.megaCore = megaCore;
    }

    @EventHandler
    public void onEvent(Event event) {
        for (String eventName : eventNames) {
            String[] names = event.getClass().getName().split("\\.");
            String finalEventName = names[names.length - 1];
            if (!finalEventName.equals(eventName)) continue;

            tryToHandleEvent(event);
        }
    }

    private void tryToHandleEvent(Event event) {
        try {
            Optional<Method> method = Arrays.stream(event.getClass().getMethods())
                    .filter(m -> m.getReturnType().equals(Player.class))
                    .findAny();
            if (method.isEmpty()) return;

            Player player = (Player) method.get().invoke(event);
            Optional<User> user = AfterRomeAPI.getUser(player);
            if (user.isEmpty()) return;

            MegaManager.getManager(EventManager.class).handleEvent(user.get(), event);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
