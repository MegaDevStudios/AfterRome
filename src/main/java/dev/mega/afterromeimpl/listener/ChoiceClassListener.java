package dev.mega.afterromeimpl.listener;

import dev.mega.afterrome.event.PreClassChoiceEvent;
import dev.mega.afterrome.user.User;
import dev.mega.afterromeimpl.menu.choice.ChoiceMenu;
import dev.mega.megacore.MegaCore;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ChoiceClassListener implements Listener {
    private final MegaCore megaCore;

    public ChoiceClassListener(MegaCore megaCore) {
        this.megaCore = megaCore;
    }

    @EventHandler
    public void onUserChoice(PreClassChoiceEvent event) {
        User user = event.getUser();

        ChoiceMenu choiceMenu = new ChoiceMenu(user, megaCore);
        choiceMenu.open();
    }
}
