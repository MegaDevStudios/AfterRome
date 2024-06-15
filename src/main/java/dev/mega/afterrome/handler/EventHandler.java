package dev.mega.afterrome.handler;

import dev.mega.afterrome.config.data.SkillSection;
import dev.mega.afterrome.config.data.event.EventSection;
import dev.mega.afterrome.config.data.event.LevelSection;
import dev.mega.afterrome.config.data.event.ValueSection;
import dev.mega.afterrome.config.data.execute.ExecuteSection;
import dev.mega.afterrome.parser.Parser;
import dev.mega.afterrome.user.User;
import dev.mega.afterrome.util.ProbabilityCalculator;
import lombok.Getter;
import org.bukkit.event.Event;

import java.util.List;
import java.util.Optional;

@Getter
public class EventHandler {
    private final User user;
    private final Event event;

    private final List<EventSection> eventSections;

    public EventHandler(User user, Event event) {
        this.user = user;
        this.event = event;
        this.eventSections = Parser.getInstance().getAvailableEventSections(user, event);
    }

    public void handleEvent() {
        if (eventSections.isEmpty()) return;

        List<SkillSection> skillSections = Parser.getInstance()
                .getSkillSectionBy(user, event);

        for (SkillSection skillSection : skillSections) {
            handleSkillSections(skillSection);
        }
    }

    private void handleSkillSections(SkillSection skillSection) {
        Optional<Integer> userLevel = Parser.getInstance().getUserLevel(user, skillSection);
        if (userLevel.isEmpty()) return;

        for (EventSection eventSection : eventSections) {
            Optional<LevelSection> levelSection = getLevelSectionBy(eventSection,
                    userLevel.get());
            if (levelSection.isEmpty()) return;

            handleEventSection(levelSection.get());
        }
    }

    private void handleEventSection(LevelSection levelSection) {
        List<ExecuteSection> executeSections =
                Parser.getInstance().getExecutesIfMatches(user, event);

        switch (levelSection.getValueType()) {
            case CHANCE -> handleChance(levelSection, executeSections);
            case MULTIPLIER -> handleMultiplier(levelSection, executeSections);
        }

    }

    private void handleMultiplier(LevelSection levelSection,
                             List<ExecuteSection> executeSections) {

        for (int i = 0; i < levelSection.getValues().get(0).getCount(); i++) {
            executeSections.forEach(executeSection -> executeSection.getSkill()
                    .execute(user, event));
        }
    }

    private void handleChance(LevelSection levelSection,
                              List<ExecuteSection> executeSections) {

        double[] probabilities = levelSection.getValues().stream()
                .mapToDouble(ValueSection::getPercent).toArray();

        probabilities = ProbabilityCalculator.validateAndGet(probabilities);
        int indexEvent = ProbabilityCalculator.choiceOne(probabilities);

        executeSections.get(indexEvent).getSkill().execute(user, event);
    }

    private Optional<LevelSection> getLevelSectionBy(EventSection eventSection,
                                                     int userLevel) {
        return eventSection.getLevelSections().stream()
                .filter(ls -> ls.getLevel() == userLevel)
                .findAny();
    }
}
