package quests;

import character.entities.Bystander;
import character.entities.Player;

import org.junit.jupiter.api.Test;
import quests.entities.PlayersStatistics;
import quests.entities.Quest;
import quests.use_cases.Reward;
import quests.use_cases.StatisticalReward;
import quests.use_cases.StatisticalTask;
import quests.use_cases.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the testing for the entities composing a Quest.
 */
public class QuestEntityTest {
    /**
     * Tests about the tasks.
     */
    @Test
    void taskNotCompletedTest() {
        Task task = new StatisticalTask(PlayersStatistics.MONEY, 100);
        Player player = new Player("", null);

        assert (!task.isCompleted(player));
    }

    @Test
    void taskCompletedTest() {
        Task task = new StatisticalTask(PlayersStatistics.MONEY, 100);
        Player player = new Player("", null);
        player.changeMoney(100);

        assert (task.isCompleted(player));
    }

    /**
     * Tests about the Rewards.
     */

    @Test
    void distributeRewardTest() {
        Reward reward = new StatisticalReward(PlayersStatistics.EXPERIENCE, 20);
        Player player = new Player("", null);

        assert player.getExperience() == 0;

        reward.distribute(player);

        assert player.getExperience() == 20;
    }

    /**
     * Test about the quest.
     */

    // helper method to creating the setting for testing that a basic Quest.
    // returns a Quest object.
    Quest getQuest() {
        Bystander bystander = new Bystander("", false);
        Reward reward = new StatisticalReward(PlayersStatistics.EXPERIENCE, 1000);
        List<Task> tasks = new ArrayList<>();
        tasks.add(new StatisticalTask(PlayersStatistics.HEALTH, 50));
        tasks.add(new StatisticalTask(PlayersStatistics.MONEY, 100));

        return new Quest("Challenge", "Here is the challenge", bystander, reward, tasks);
    }

    // helper method to complete the tasks.
    void completeTasksOfQuest(List<Task> tasks, Player player) {
        for (Task task: tasks) {
            task.isCompleted(player);
        }
    }

    @Test
    void questCompletionTest() {
        Quest quest = this.getQuest();
        Player player = new Player("", null);

        assert (!quest.isCompleted());

        this.completeTasksOfQuest(quest.getTasks(), player);

        assert (!quest.isCompleted());

        player.changeMoney(120);
        this.completeTasksOfQuest(quest.getTasks(), player);

        assert (quest.isCompleted());
    }

    /**
     * Testing that the savable functionality works.
     */
    @Test
    void saveAbleQuest() {
        String questInformation = (this.getQuest().new SaveQuest()).toSavableString();
        String[] questAttributes = questInformation.split("\\|");

        assert questAttributes.length == 8;

        assert questAttributes[0].equals("Challenge");
        assert this.getQuest().getReward().toString().equals(questAttributes[6]);
    }

    /**
     * Testing
     */
    @Test
    void fromStringQuest() {
        String information = (this.getQuest().new SaveQuest()).toSavableString();

        Quest newQuest = new Quest("", "", new Bystander("", false),
                null, new ArrayList<>());
        (newQuest.new SaveQuest()).fromSavableString(information);

        assert newQuest.isRewardDistributed() == this.getQuest().isRewardDistributed();
        assert newQuest.getReward().toString().equals(this.getQuest().getReward().toString());
    }
}
