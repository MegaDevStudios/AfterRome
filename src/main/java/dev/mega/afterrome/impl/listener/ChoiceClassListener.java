package dev.mega.afterrome.impl.listener;

import dev.mega.afterrome.core.event.PreClassChoiceEvent;
import dev.mega.afterrome.core.user.User;
import dev.mega.afterrome.impl.menu.choice.ChoiceMenu;
import dev.mega.megacore.MegaCore;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class ChoiceClassListener implements Listener {
    private final MegaCore megaCore;

    public ChoiceClassListener(MegaCore megaCore) {
        this.megaCore = megaCore;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onUserChoice(PreClassChoiceEvent event) {
        User user = event.getUser();

        ChoiceMenu choiceMenu = new ChoiceMenu(user, megaCore);
        choiceMenu.open();
    }
}
