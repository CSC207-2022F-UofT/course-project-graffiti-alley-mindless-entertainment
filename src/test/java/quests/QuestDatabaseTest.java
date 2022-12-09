package quests;

import database.entities.QuestData;

import database.entities.QuestGiverEventData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class QuestDatabaseTest {

    /**
     * @return a generic QuestData object to be used in test below.
     */
    QuestData getGenericQuestData() {
        ArrayList<String> tasksTypes = new ArrayList<>();
        tasksTypes.add("statistical");
        tasksTypes.add("statistical");
        ArrayList<String> tasksStatistics = new ArrayList<>();
        tasksStatistics.add("level");
        tasksStatistics.add("health");
        ArrayList<Long> tasksValues = new ArrayList<>();
        tasksValues.add((long) 5);
        tasksValues.add((long) 80);

        return new QuestData(
                "Challenger", "Meeting a challenger!", "Michele", "statistical",
                "money", 1000, tasksTypes, tasksStatistics, tasksValues
        );
    }

    /**
     * Checks that the parameters in QuestData have been initialized & assigned correctly.
     */
    @Test
    void testQuestData() {
        QuestData data = this.getGenericQuestData();

        assert (data.name.equalsIgnoreCase("Challenger"));
        assert (data.description.equalsIgnoreCase("Meeting a challenger!"));
        assert (data.bystander.equalsIgnoreCase("Michele"));
        assert (data.rewardType.equalsIgnoreCase("statistical"));
        assert (data.rewardStatistic.equalsIgnoreCase("money"));
        assert (data.rewardValue == 1000);
        assert (data.tasksTypes.size() == 2);
        assert (data.tasksTypes.get(0).equalsIgnoreCase("statistical"));
        assert (data.tasksTypes.get(1).equalsIgnoreCase("statistical"));
        assert (data.tasksStatistics.size() == 2);
        assert (data.tasksStatistics.get(0).equalsIgnoreCase("level"));
        assert (data.tasksStatistics.get(1).equalsIgnoreCase("health"));
        assert (data.tasksValues.size() == 2);
        assert (data.tasksValues.get(0) == 5);
        assert (data.tasksValues.get(1) ==80);
    }

    /**
     * @return a generic QuestGiverEventData object.
     */
    QuestGiverEventData getGenericQuestGiverEventData() {
        return new QuestGiverEventData(
                "test name", "test type", "test quest name", "test npc"
        );
    }

    /**
     * Checks that the parameters of QuestGiverEvent object have been initialized properly.
     */
    @Test
    void testQuestGiverEventData() {
        QuestGiverEventData data = getGenericQuestGiverEventData();

        assert (data.name.equalsIgnoreCase("test name"));
        assert (data.type.equalsIgnoreCase("test type"));
        assert (data.quest.equalsIgnoreCase("test quest name"));
        assert (data.npc.equalsIgnoreCase("test npc"));
    }
}
