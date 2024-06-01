package com.megadev.afterrome.object.menu.shop;

import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.config.manager.ShopManager;
import com.megadev.afterrome.config.shop.ShopConfig;
import com.megadev.afterrome.object.menu.AbstractMenu;
import com.megadev.afterrome.object.user.User;

public class ShopMenu extends AbstractMenu {
    public ShopMenu(User user, int rows) {
        super(user, rows);
    }

    @Override
    protected void setMenuItems() {
        for (int i = 0; i < getItems().length; i++) {

        }
    }

    @Override
    public String getMenuName() {
        ShopManager shopManager = ConfigManager.getInstance().getManager(ShopManager.class);
        return shopManager.getConfig(ShopConfig.class).getMenuName();
    }
}
