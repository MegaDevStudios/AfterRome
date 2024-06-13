package dev.mega.afterrome.config.data.event;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EventSectionTest {
    private EventSection eventSection;

    @BeforeEach
    void setup() {
        eventSection = new EventSection("BlockBreakEvent",
                List.of(),
                List.of(
                        new ConditionSection(List.of(
                                new MethodSection("getBlock.getType", List.of("STONE", "DIRT"))
                        ), true),
                        new ConditionSection(List.of(
                                new MethodSection("getBlock.getType", List.of("GRASS_BLOCK"))
                        ), false)
                ),
                List.of());
    }

    @Test
    void matches() {
        Block block = mock(Block.class);
        BlockBreakEvent blockBreakEvent = new BlockBreakEvent(block, mock(Player.class));

        when(block.getType()).thenReturn(Material.DIRT);
        assertTrue(eventSection.matches(blockBreakEvent));

        when(block.getType()).thenReturn(Material.GRASS_BLOCK);
        assertFalse(eventSection.matches(blockBreakEvent));
    }
}
