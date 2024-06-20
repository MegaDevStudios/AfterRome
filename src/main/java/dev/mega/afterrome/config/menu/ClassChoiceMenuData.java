package dev.mega.afterrome.config.menu;

import dev.mega.afterrome.config.menu.item.HeadSection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class ClassChoiceMenuData {
    private final String title;
    private final List<HeadSection> headSections;
}
