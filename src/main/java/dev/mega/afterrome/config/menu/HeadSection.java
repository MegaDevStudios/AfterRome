package dev.mega.afterrome.config.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class HeadSection {
    private final int slot;
    private final String name;
    private final List<String> lore;
    private final String texture;
}
