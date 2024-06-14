package com.megadev.afterrome.config.profession;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class AgronomistConfig extends ProfessionConfig {
    public AgronomistConfig(@NotNull Plugin plugin, String... path) {
        super(plugin, path);
    }

//    public List<ItemStack> getUncreatedItems(SkillType type) {
//        return switch (type) {
//            case BLACKSMITH -> getBlacksmithItems();
//            case HORSEMAN -> getHorsemanItems();
//            case TOOLMAKER -> getToolmakerItems();
//            default -> null;
//        };
//    }
//
//    private List<ItemStack> getBlacksmithItems() {
//        List<ItemStack> items = new ArrayList<>();
//    }
//
//    private List<ItemStack> getHorsemanItems() {
//        List<ItemStack> items = new ArrayList<>();
//    }
//
//    private List<ItemStack> getToolmakerItems() {
//        List<ItemStack> items = new ArrayList<>();
//    }
}
