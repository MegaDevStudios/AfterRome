package dev.mega.afterromeimpl.object.menu.upgrade;

import dev.mega.afterrome.user.Profession;
import dev.mega.afterrome.user.User;

public class Aesculapius extends AbstractUpgradeMenu {
    public Aesculapius(User user, Profession profession) {
        super(user, profession);
    }

    @Override
    public String getMenuName() {
        return ""; //TODO: вернуть название меню

    }
}
