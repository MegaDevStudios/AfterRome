package dev.mega.afterrome.config.data.event;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MethodSectionTest {

    @Test
    void testBlockTypeOfEventEqualsStone() {
        MethodSection methodSection = new MethodSection("getBlock.getType", List.of("STONE"));

        BlockBreakEvent blockBreakEvent = mock(BlockBreakEvent.class);
        Block block = mock(Block.class);
        when(blockBreakEvent.getBlock()).thenReturn(block);
        when(block.getType()).thenReturn(Material.STONE);

        assertTrue(methodSection.matches(blockBreakEvent));
    }
}