package dev.mega.afterrome.impl.parser;

import dev.mega.afterrome.core.config.data.ConfigData;
import dev.mega.afterrome.core.config.data.ProfessionSection;
import dev.mega.afterrome.core.config.data.SkillSection;
import dev.mega.afterrome.core.config.data.event.ConditionSection;
import dev.mega.afterrome.core.config.data.event.EventSection;
import dev.mega.afterrome.core.config.data.execute.ExecuteSection;
import dev.mega.afterrome.core.manager.ProfessionManager;
import dev.mega.afterrome.core.parser.ParserHandler;
import dev.mega.afterrome.core.user.Profession;
import dev.mega.afterrome.core.user.Skill;
import dev.mega.afterrome.core.user.User;
import dev.mega.megacore.manager.MegaManager;
import lombok.Setter;
import org.bukkit.event.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArParserHandler implements ParserHandler {
    @Setter
    private ConfigData configData;
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
    public List<ConditionSection> getConditionOf(Profession profession, Event event) {
        return configData.getProfessions().stream()
                .flatMap(professionSection -> professionSection.getSkills().stream()
                        .flatMap(skillSection -> skillSection.getEvents().stream()
                                .filter(eventSection -> eventSection.getName().equals(event.getEventName()))
                                .flatMap(eventSection -> eventSection.getConditionSections().stream())))
                .collect(Collectors.toList());
    }

    @Override
    public List<ExecuteSection> getExecutesIfMatches(User user, Event event) {
        return configData.getProfessions().stream()
                .filter(professionSection -> professionSection.getName().equals(user.getProfession().getName()))
                .flatMap(professionSection -> professionSection.getSkills().stream()
                        .flatMap(skillSection -> skillSection.getExecutorsIfMatches(event).stream()))
                .collect(Collectors.toList());
    }

    @Override
    public List<EventSection> getAvailableEventSections(User user, Event event) {
        return configData.getProfessions().stream()
                .filter(professionSection -> professionSection.getName().equals(user.getProfession().getName()))
                .flatMap(professionSection -> professionSection.getSkills().stream()
                        .flatMap(skillSection -> skillSection.getEvents().stream())
                        .filter(eventSection -> eventSection.matches(event)))
                .collect(Collectors.toList());
    }

    @Override
    public List<SkillSection> getSkillSectionsBy(User user, Event event) {
        return configData.getProfessions().stream()
                .filter(ps -> ps.getName().equals(user.getProfession().getName()))
                .flatMap(ps -> ps.getSkills().stream()
                        .filter(skillSection -> skillSection.getEvents().stream()
                                .anyMatch(es -> es.matches(event)))
                ).toList();
    }

    @Override
    public void registerProfessionsEvents() {
        MegaManager.getManager(ProfessionManager.class).registerEvents(
                new ArrayList<>(configData.getProfessions().stream()
                        .flatMap(ps -> ps.getSkills().stream())
                        .flatMap(ss -> ss.getEvents().stream())
                        .map(EventSection::getName).toList())
        );
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
