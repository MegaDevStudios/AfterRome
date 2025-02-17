package dev.mega.afterrome;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.mega.afterrome.core.config.data.ConfigData;
import dev.mega.afterrome.core.config.data.ProfessionSection;
import dev.mega.afterrome.core.config.data.SkillSection;
import dev.mega.afterrome.core.config.data.event.*;
import dev.mega.afterrome.core.config.data.execute.Boost;
import dev.mega.afterrome.core.config.data.execute.ExecuteSection;
import dev.mega.afterrome.core.config.menu.ChoiceClassMenu;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class JsonTest {
    @Test
    public void testConfigData() {
        List<ValueSection> valueSections = new ArrayList<>();
        valueSections.add(new ValueSection(50, 1));
        valueSections.add(new ValueSection(20, 2));
        valueSections.add(new ValueSection(15, 3));
        valueSections.add(new ValueSection(10, 4));
        valueSections.add(new ValueSection(5, 5));

        List<LevelSection> levelSections = new ArrayList<>();
        levelSections.add(new LevelSection(1, valueSections, LevelSection.Type.CHANCE));

        List<MethodSection> methodSections = new ArrayList<>();
        methodSections.add(new MethodSection("%type%", List.of("STONE", "GRAVEL")));

        List<ConditionSection> conditionSections = new ArrayList<>();
        conditionSections.add(new ConditionSection(methodSections, true));

        List<ExecuteSection> executeSections = new ArrayList<>();
        executeSections.add(new ExecuteSection(new Boost()));

        List<EventSection> events = new ArrayList<>();
        events.add(new EventSection("BlockBreakEvent", levelSections, conditionSections, executeSections));

        List<SkillSection> skills = new ArrayList<>();
        skills.add(new SkillSection("FARMER", events));

        List<ProfessionSection> professionSections = new ArrayList<>();
        professionSections.add(new ProfessionSection("AGRONOMIST", true, skills, null, null));

        ConfigData configData = new ConfigData(professionSections, new ChoiceClassMenu("null",null, null));

        Gson gs = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gs.toJson(configData);

        System.out.print(jsonString);
    }
}
