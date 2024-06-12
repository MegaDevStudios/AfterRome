package dev.mega.afterrome.listener;

import dev.mega.megacore.MegaCore;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.PluginManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProfessionListenerTest {

    @BeforeEach
    void setup() {
        Server server = mock(Server.class);

        Logger logger = mock(Logger.class);
        when(server.getLogger()).thenReturn(logger);

        Bukkit.setServer(server);

        PluginManager pluginManager = mock(PluginManager.class);
        when(Bukkit.getPluginManager()).thenReturn(pluginManager);

        MegaCore megaCore = mock(MegaCore.class);
        when(Bukkit.getPluginManager().getPlugin(megaCore.getName())).thenReturn(megaCore);

        List<String> eventNames = new ArrayList<>(List.of(new String[]{"BlockBreakEvent"}));
        ProfessionListener professionListener = new ProfessionListener(megaCore, eventNames);

        Bukkit.getPluginManager().registerEvents(professionListener, megaCore );
    }

    @Test
    void testEvent() {
        boolean expected = false;
        try {
//            expected = professionListener.onEvent(mock(BlockBreakEvent.class));
            Bukkit.getPluginManager().callEvent(mock(BlockBreakEvent.class));
        } catch (Exception ex) {
            fail("expected exception not to be thrown (see cause)", ex);
        }

        System.out.println("Hey! It passed");

        Assertions.assertTrue(expected);
    }
}