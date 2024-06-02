package com.megadev.afterrome.util;

import com.megadev.afterrome.object.user.User;
import org.bukkit.inventory.ItemStack;

public class SaleTransaction {
    public static void transaction(User user, ItemStack saleItem, int points) {
        user.addPoints(points);
    }
}
