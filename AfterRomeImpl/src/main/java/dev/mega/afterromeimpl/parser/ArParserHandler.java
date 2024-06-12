package dev.mega.afterromeimpl.parser;

import dev.mega.afterrome.config.data.ConfigData;
import dev.mega.afterrome.config.data.ProfessionSection;
import dev.mega.afterrome.config.data.SkillSection;
import dev.mega.afterrome.config.data.event.EventSection;
import dev.mega.afterrome.config.data.execute.ExecuteSection;
import dev.mega.afterrome.listener.ProfessionListener;
import dev.mega.afterrome.manager.ProfessionManager;
import dev.mega.afterrome.parser.ParserHandler;
import dev.mega.afterrome.user.Profession;
import dev.mega.afterrome.user.Skill;
import dev.mega.megacore.manager.MegaManager;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;

public class ArParserHandler implements ParserHandler {
    private final ConfigData configData;
    private final List<Profession> professions = new ArrayList<>();

    public ArParserHandler(ConfigData configData) {
        this.configData = configData;
    }

    @Override
    public List<Profession> getProfessions() {
        if (!professions.isEmpty()) {
            return professions;
        }

        List<ProfessionSection> professionSectionList = configData.getProfessions();

        for (ProfessionSection professionSection : professionSectionList) {
            List<Skill> skills = professionSection.getSkills().stream()
                    .map(skillSection -> Skill.of(skillSection.getName(), 0)).toList();

            professions.add(Profession.of(professionSection.getName(), skills));
        }

        return professions;
    }



    @Override
    public void registerProfessionsEvents() {
        List<String> events = new ArrayList<>();

        for (ProfessionSection professionSection : configData.getProfessions()) {
            for (SkillSection skillSection : professionSection.getSkills()) {
                for (EventSection eventSection : skillSection.getEvents()) {
                    events.add(eventSection.getName());
                }
            }
        }

        MegaManager.getManager(ProfessionManager.class).registerEvents(events);
    }

    @Override
    public List<ExecuteSection> getExecutes(Profession profession) {
        ProfessionSection professionSection = getProfessionSection(profession);
        if (professionSection == null) return new ArrayList<>();

        List<ExecuteSection> executeSections = new ArrayList<>();
        for (SkillSection skillSection : professionSection.getSkills()) {
            for (EventSection eventSection : skillSection.getEvents()) {
                executeSections.addAll(eventSection.getExecutes());
            }
        }

        return executeSections;
    }

    private ProfessionSection getProfessionSection(Profession profession) {
        List<ProfessionSection> professionSectionList = configData.getProfessions();
        for (ProfessionSection section : professionSectionList) {
            if (section.getName().equals(profession.getName()))
                return section;
        }

        return null;
    }
}
