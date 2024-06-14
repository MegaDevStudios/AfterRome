package dev.mega.afterrome.config.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UpgradeMenuSection {
    private final int rows;
    private final String MenuName;
    private final List<MenuItemSection> items;
}
