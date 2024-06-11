package dev.mega.afterrome.config.data.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter
@AllArgsConstructor
public class MethodSection {
    private final String method;
    private final List<String> matches;
}
