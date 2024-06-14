package dev.mega.afterrome.config.menu;

import dev.mega.megacore.inventory.builder.menu.MenuItemBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class MenuItemSection {
    private final MenuItemBuilder item;
    private final String name;
    private final List<String> lore;
    private final int slot;
}
