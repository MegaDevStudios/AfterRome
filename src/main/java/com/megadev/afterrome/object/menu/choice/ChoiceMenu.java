package com.megadev.afterrome.object.menu.choice;

import com.megadev.afterrome.config.MainConfig;
import com.megadev.afterrome.object.item.HeadBuilder;
import com.megadev.afterrome.object.menu.AbstractMenu;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.user.User;

import org.bukkit.Material;

public class ChoiceMenu extends AbstractMenu {
    public ChoiceMenu(User user) {
        super(user, 3);
    }

    @Override
    protected void setMenuItems() {
        MainConfig mainConfig = getConfigManager().getConfig(MainConfig.class);

        fillItems();

        setItem(new HeadBuilder(mainConfig.getAgronomistTexture())
                .setName(mainConfig.getAgronomistName())
                .setLore(mainConfig.getAgronomistLore()).toMenuItem(), 9);

        setItem(new HeadBuilder(mainConfig.getArtisanTexture())
                .setName(mainConfig.getArtisanName())
                .setLore(mainConfig.getArtisanLore()).toMenuItem(), 11);

        setItem(new HeadBuilder(mainConfig.getSonOfMarsTexture())
                .setName(mainConfig.getSonOfMarsName())
                .setLore(mainConfig.getSonOfMarsLore()).toMenuItem(), 13);

        setItem(new HeadBuilder(mainConfig.getForesterTexture())
                .setName(mainConfig.getForesterName())
                .setLore(mainConfig.getForesterLore()).toMenuItem(), 15);

        setItem(new HeadBuilder(mainConfig.getAesculapiusTexture())
                .setName(mainConfig.getAesculapiusName())
                .setLore(mainConfig.getAesculapiusLore()).toMenuItem(), 17);
    }

    @Override
    public String getMenuName() {
        return getConfigManager().getConfig(MainConfig.class).getChoiceMenuName();
    }

    private void fillItems() {
        for (int i = 0; i < getSize(); i++) {
            if (i % 2 == 0) setItem(new MenuItem(Material.WHITE_STAINED_GLASS_PANE), i);
            else setItem(new MenuItem(Material.BLACK_STAINED_GLASS_PANE), i);
        }
    }
}
