package dev.mega.afterrome.config.menu;

import dev.mega.megacore.inventory.builder.menu.MenuItemBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class MenuItemSection {
    private final MenuItemBuilder item;
    private final String skillName; //Сюда вписывается название скилла к которому относится предмет если он у него есть
    private final String name;      //Это название которое выводится в меню
    private final List<String> lore;
    private final int slot;
    private final ItemExecuteSection execute;
}
