package dev.mega.afterrome.core.config.menu;

import dev.mega.afterrome.core.config.menu.item.MenuItemSection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class UpgradeMenuSection {
    private final int rows;
    private final String MenuName;
    private final List<MenuItemSection> items;
}
