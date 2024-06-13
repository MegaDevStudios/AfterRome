package dev.mega.afterrome.manager;

import org.bukkit.Material;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class ProfessionManagerTest {

    @Test
    void handleEvent() throws Exception {
        Method method = this.getClass().getDeclaredMethod("getMaterial");
        method.setAccessible(true);
        if (method.getReturnType() == Void.TYPE) fail();

        Object value = method.invoke(this);
        assertEquals("STONE", String.valueOf(value));
    }

    private Material getMaterial() {
        return Material.STONE;
    }

    private enum TestEnum {
        TEST1,
        TEST2
    }
}