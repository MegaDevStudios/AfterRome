package com.megadev.afterrome.object.menu.shop;

import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.config.shop.sale.NPCConfig;
import com.megadev.afterrome.config.shop.sale.SaleConfig;
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

        SaleConfig saleConfig = profession.getSaleConfig();

        setItem(new MenuItem(saleConfig.getBook()), getSize() / 2);
    }

    @Override
    public String getMenuName() {
        return ConfigManager.getInstance().getConfig(NPCConfig.class).getMenuName();
    }
}
