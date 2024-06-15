package dev.mega.afterrome.config.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ItemExecuteSection {
    private final boolean clicked;
    private final ItemExecute itemExecute;
}
