package questSystem;

import database.objects.QuestData;
import game_world.factories.QuestFactory;

import org.junit.jupiter.api.Test;
import quests.Quest;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains some tests to verify the QuestFactory proper functioning.
 */
public class QuestFactoryTest {

    /**
     * @return sample QuestData object that will be used in the Test.
     */
    QuestData createQuestData() {
        ArrayList<String> tasksTypes = new ArrayList<>();
        tasksTypes.add("statistical");
        ArrayList<String> tasksStatistics = new ArrayList<>();
        tasksStatistics.add("health");
        ArrayList<Long> tasksValues = new ArrayList<>();
        tasksValues.add((long) 90);



        return new QuestData(
                "Mortal Challenge", "", "Charlotte",
                "statistical", "money", 100,
                tasksTypes, tasksStatistics, tasksValues
        );
    }

    ///**
    // * @return Quest object created using the factory and QuestData.
    // */
    //Quest createQuest(QuestData data) {
    //    QuestFactory factory = new QuestFactory();

    //    return factory.createQuest(data);
    //}

    //@Test
    //void questCreationTest() {
        //Quest quest = createQuest(createQuestData());

        // add the assert statements here.
    //}

}
