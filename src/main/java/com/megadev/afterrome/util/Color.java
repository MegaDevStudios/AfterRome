package com.megadev.afterrome.util;

import org.bukkit.ChatColor;

public class Color {
    public static String colorize(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
