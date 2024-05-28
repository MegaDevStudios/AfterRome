package com.megadev.afterrome.object.profession;

import com.megadev.afterrome.config.profession.AgronomistConfig;
import com.megadev.afterrome.object.menu.AbstractUpgradeMenu;
import com.megadev.afterrome.object.menu.shop.upgrade.menu.AgronomistMenu;
import com.megadev.afterrome.object.user.AfterRomeUser;
import com.megadev.afterrome.object.user.User;
import org.bukkit.entity.Player;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ProfessionTest {

    @Test
    void getUpgradeMenu() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Profession<AgronomistConfig, AgronomistMenu> profession = mock(Profession.class);

        Player player = mock(Player.class);

        User user = new AfterRomeUser(player);

        AbstractUpgradeMenu abstractUpgradeMenu = profession.getUpgradeMenu(user);
        assertEquals("", abstractUpgradeMenu.getMenuName());

    }
}