package objects.battle;

import io.Output;
import io.OutputHandler;
import objects.character.EnemyFacade;
import objects.character.Player;

public class StatDisplayer {
    /**
     * Attributes:
     * output: Screen that allows for output
     * user: Player object whose stats are being referenced
     * foe: Enemy object whose stats are being referenced
     */
    private final OutputHandler output = Output.getScreen();
    public StatDisplayer() {

    }

    /**
     * Displays the stats of the user and the enemy.
     */
    public void displayStats(Player user) {
        String userStats = "Name: " + user.getName() +
                " | HP: " + user.getCurrHealth() +
                " | Speed: " + user.getSpeed() +
                " | Type: " + user.getSkillType();
        output.generateText("[PLAYER STATS] " + userStats + "\n");
    }
    public void displayStats(EnemyFacade foe) {
        String foeStats = "Name: " + foe.getName() +
                " | HP: " + foe.getHealth() +
                " | Speed: " + foe.getSpeed() +
                " | Type: " + foe.getType();
        output.generateText("[ENEMY STATS] " + foeStats + "\n");
    }

}
