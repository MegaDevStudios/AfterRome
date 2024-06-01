package com.megadev.afterrome.object.menu.shop;

import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.config.shop.ShopConfig;
import com.megadev.afterrome.object.item.ItemBuilder;
import com.megadev.afterrome.object.menu.AbstractMenu;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.profession.Profession;
import com.megadev.afterrome.object.user.User;
import org.bukkit.Material;

public class ShopMenu extends AbstractMenu {
    Profession profession;

    public ShopMenu(User user, int rows) {
        super(user, rows);
        this.profession = user.getProfession();
    }

    @Override
    protected void setMenuItems() {
        for (int i = 0; i < getSize(); i++) {
            if (i == getSize() / 2) continue;

            setItem(new MenuItem(Material.GRAY_STAINED_GLASS_PANE), i);
        }

        setItem(new MenuItem(new ItemBuilder(Material.WRITABLE_BOOK)
                .setName(profession.getNameOfProfession())
                .setLore("&8Блок пшеницы - 2 очка", "&8Перья 11шт - 4 очка", "&8Золотое яблоко - 10 очков")
                .toItemStack()
        ), getSize() - 1);

    }

    @Override
    public String getMenuName() {
        return ConfigManager.getInstance().getConfig(ShopConfig.class).getMenuName();
    }
}
