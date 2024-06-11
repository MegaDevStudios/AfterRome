package dev.mega.afterrome.config.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.mega.afterrome.config.data.event.ConditionSection;
import dev.mega.afterrome.config.data.event.EventSection;
import dev.mega.afterrome.config.data.event.LevelSection;
import dev.mega.afterrome.config.data.event.MethodSection;
import dev.mega.afterrome.config.data.execute.Boost;
import dev.mega.afterrome.config.data.execute.ExecuteSection;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class ConfigDataTest {

    @Test
    public void testConfigData() {
        List<LevelSection> levelSections = new ArrayList<>();
        levelSections.add(new LevelSection(1, 50, 1, LevelSection.Type.CHANCE));
        levelSections.add(new LevelSection(1, 30, 2, LevelSection.Type.CHANCE));
        levelSections.add(new LevelSection(1, 20, 3, LevelSection.Type.CHANCE));
        levelSections.add(new LevelSection(1, 20, 4, LevelSection.Type.CHANCE));
        levelSections.add(new LevelSection(1, 20, 5, LevelSection.Type.CHANCE));
        levelSections.add(new LevelSection(2, 50, 1, LevelSection.Type.CHANCE));
        levelSections.add(new LevelSection(2, 30, 2, LevelSection.Type.CHANCE));
        levelSections.add(new LevelSection(3, 20, 3, LevelSection.Type.CHANCE));
        levelSections.add(new LevelSection(3, 20, 4, LevelSection.Type.CHANCE));
        levelSections.add(new LevelSection(3, 20, 5, LevelSection.Type.CHANCE));

        List<MethodSection> methodSections = new ArrayList<>();
        methodSections.add(new MethodSection("%type%", List.of("STONE", "GRAVEL")));

        List<ConditionSection> conditionSections = new ArrayList<>();
        conditionSections.add(new ConditionSection(methodSections, true));

        List<ExecuteSection> executeSections = new ArrayList<>();
        executeSections.add(new ExecuteSection(new Boost(), ExecuteSection.Type.BOOST));

        List<EventSection> events = new ArrayList<>();
        events.add(new EventSection("PlayerJoinEvent", levelSections, conditionSections, executeSections));

        List<SkillSection> skills = new ArrayList<>();
        skills.add(new SkillSection("FARMER", events));

        List<ProfessionSection> professionSections = new ArrayList<>();
        professionSections.add(new ProfessionSection("AGRONOMIST", skills));

        ConfigData configData = new ConfigData(professionSections);

        Gson gs = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gs.toJson(configData.getProfessions());

        System.out.print(jsonString);
    }

}