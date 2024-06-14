package dev.mega.afterromeimpl.object.menu.upgrade;

import dev.mega.afterrome.user.Profession;
import dev.mega.afterrome.user.User;

public class UpgradeMenu extends AbstractUpgradeMenu {
    String name;

    public UpgradeMenu(User user, Profession profession, String name) {
        super(user, profession);
        this.name = name;
    }

    @Override
    public String getTitle() {
        return name;
    }
}
