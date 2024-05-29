package com.megadev.afterrome.object.menu.shop.upgrade.menu;

import com.megadev.afterrome.object.menu.AbstractUpgradeMenu;
import com.megadev.afterrome.object.profession.Profession;
import com.megadev.afterrome.object.user.User;

public class AesculapiusMenu extends AbstractUpgradeMenu {
    public AesculapiusMenu(User user, Profession profession) {
        super(user, profession);
    }

    @Override
    public String getMenuName() {
        return "Меню эскулапа";
    }
}
