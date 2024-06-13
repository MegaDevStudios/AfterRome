package dev.mega.afterrome.config.menu;

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
