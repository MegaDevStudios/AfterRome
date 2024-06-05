package dev.mega.afterromeimpl.listener;

import dev.mega.afterrome.event.PreClassChoiceEvent;
import dev.mega.afterrome.user.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ChoiceClassListener implements Listener {
    @EventHandler
    public void onOpenChoiceMenu(PreClassChoiceEvent event) {
        User user = event.getUser();

    }
}
