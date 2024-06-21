package dev.mega.afterrome.core.manager;

import dev.mega.afterrome.core.config.data.ConfigData;
import dev.mega.afterrome.core.config.data.ProfessionSection;
import dev.mega.afterrome.core.parser.Parser;
import dev.mega.afterrome.impl.parser.ArParserHandler;
import dev.mega.megacore.MegaCore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProfessionManagerTest {

    private ProfessionManager professionManager;

    @BeforeEach
    void setup() {
        Parser.getInstance().setParserHandler(new ArParserHandler(getConfigData()));

        professionManager = new ProfessionManager(getMegaCore());
    }

    @Test
    void loadProfessions() {
        professionManager.loadProfessions();

        assertEquals(2, professionManager.getProfessionListMap().size());
    }

    private MegaCore getMegaCore() {
        MegaCore megaCore = mock(MegaCore.class);
        when(megaCore.getDataFolder()).thenReturn(new File("."));
        return megaCore;
    }

    private ConfigData getConfigData() {
        ConfigData configData = mock(ConfigData.class);

        when(configData.getProfessions()).thenReturn(List.of(
                mock(ProfessionSection.class),
                mock(ProfessionSection.class)
        ));

        return configData;
    }
}