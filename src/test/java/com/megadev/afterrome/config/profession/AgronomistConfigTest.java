package com.megadev.afterrome.config.profession;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(AgronomistConfig.class)
public class AgronomistConfigTest {

    @Test
    public void getPercents() {
        AgronomistConfig agronomistConfig = mock(AgronomistConfig.class);

        String path = "skill.farmer.level.1.fetus1";
        when(agronomistConfig.getPercentValue(path)).thenReturn("10");

        assertEquals(10.0, agronomistConfig.getPercent(1, AgronomistConfig.LevelType.FETUS, 0));
    }
}