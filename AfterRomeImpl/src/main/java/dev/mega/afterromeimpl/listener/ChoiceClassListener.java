package dev.mega.afterromeimpl.listener;

import dev.mega.afterrome.event.PreClassChoiceEvent;
import dev.mega.afterrome.user.User;
import dev.mega.afterromeimpl.object.menu.choice.ChoiceMenu;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ChoiceClassListener implements Listener {
    @EventHandler
    public void onUserChoice(PreClassChoiceEvent event) {
        User user = event.getUser();

        ChoiceMenu choiceMenu = new ChoiceMenu(user);
        choiceMenu.open();
    }
}
