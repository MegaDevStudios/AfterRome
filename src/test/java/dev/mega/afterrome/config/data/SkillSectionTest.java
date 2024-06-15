package dev.mega.afterrome.config.data;

import dev.mega.afterrome.config.data.event.ConditionSection;
import dev.mega.afterrome.config.data.event.EventSection;
import dev.mega.afterrome.config.data.event.MethodSection;
import dev.mega.afterrome.config.data.execute.Boost;
import dev.mega.afterrome.config.data.execute.ExecuteSection;
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

class SkillSectionTest {

    private SkillSection skillSection;
    private BlockBreakEvent blockBreakEvent;
    private Block block;

    @BeforeEach
    void setup() {
        skillSection = new SkillSection("FARMER", List.of(
                new EventSection("BlockBreakEvent",
                        List.of(),
                        List.of(
                                new ConditionSection(List.of(
                                        new MethodSection("getBlock.getType", List.of("STONE", "DIRT"))
                                ), true),
                                new ConditionSection(List.of(
                                        new MethodSection("getBlock.getType", List.of("GRASS_BLOCK"))
                                ), false)
                        ),
                        List.of(
                                new ExecuteSection(new Boost())
                        ))
        ));

        block = mock(Block.class);
        blockBreakEvent = new BlockBreakEvent(block, mock(Player.class));
    }

    @Test
    void testExecutorsNotEmpty() {
        when(block.getType()).thenReturn(Material.STONE);
        assertFalse(skillSection.getExecutorsIfMatches(blockBreakEvent).isEmpty());
    }

    @Test
    void testExecutorIsEmpty() {
        when(block.getType()).thenReturn(Material.BEDROCK);
        assertTrue(skillSection.getExecutorsIfMatches(blockBreakEvent).isEmpty());
    }
}