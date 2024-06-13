package dev.mega.afterrome.config.data.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Class represents the method section.
 */
@Setter @Getter
@AllArgsConstructor
public class MethodSection {
    private final String methodName;
    private final List<String> matches;

    /**
     * Checks if event has matched conditions.
     * @param event
     * @return True if event matches, False otherwise.
     */
    public boolean matches(Event event) {
        try {
            String[] methodChain = methodName.split("\\.");
            Object currentObject = event;

            for (String methodName : methodChain) {
                Method method = currentObject.getClass().getMethod(methodName);
                currentObject = method.invoke(currentObject);
                if (currentObject == null) {
                    return false;
                }
            }

            Object finalCurrentObject = currentObject;
            return matches.stream().anyMatch(match -> match.equals(String.valueOf(finalCurrentObject)));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
