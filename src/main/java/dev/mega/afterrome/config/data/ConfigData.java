package dev.mega.afterrome.config.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Class represents the configuration data.
 */
@Getter @Setter
@AllArgsConstructor
public class ConfigData {
    private final List<ProfessionSection> professions;
}
