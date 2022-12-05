package questSystem;

import objects.character.*;
import quests.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains all the tests to check that Quest, Task & Reward classes function.
 */
public class QuestTest {

    /**
     * Tests about the tasks.
     */

    @Test
    void equalityTaskNotCompletedTest() {
        Task task = new StatisticalTask("", PlayersStatistics.HEALTH, 90, true);
        Player player = new Player("", null);

        assert (!task.isCompleted(player));
    }

    @Test
    void equalityTaskCompletedTest() {
        Task task = new StatisticalTask("", PlayersStatistics.HEALTH, 90, true);
        Player player = new Player("", null);
        player.changeCurrHealth(-10);

        assert (task.isCompleted(player));
    }

    @Test
    void notEqualityTaskNotCompletedTest() {
        Task task = new StatisticalTask("", PlayersStatistics.MONEY, 100, false);
        Player player = new Player("", null);

        assert (!task.isCompleted(player));
    }

    @Test
    void notEqualityTaskCompletedTest() {
        Task task = new StatisticalTask("", PlayersStatistics.MONEY, 100, false);
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
        tasks.add(new StatisticalTask("", PlayersStatistics.HEALTH, 50, false));
        tasks.add(new StatisticalTask("", PlayersStatistics.MONEY, 100, false));

        return new Quest("", "", bystander, reward, tasks);
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
}
