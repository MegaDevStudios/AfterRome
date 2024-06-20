package dev.mega.afterrome.config.menu;

import dev.mega.afterrome.config.menu.item.HeadSection;
import dev.mega.afterrome.config.menu.item.MenuItemSection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ChoiceClassMenu {
    private final List<MenuItemSection> backgroundItems;
    private final List<HeadSection> heads;
}
