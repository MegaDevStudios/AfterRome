package dev.mega.afterromeimpl.object.menu.choice;

import dev.mega.afterrome.menu.AbstractMenu;
import dev.mega.afterrome.user.User;

public class ChoiceMenu extends AbstractMenu {
    public ChoiceMenu(User user) {
        super(user, 3);
    }

    @Override
    public String getMenuName() {
        return "";
    }

    @Override
    protected void setMenuItems() {

    }
}
