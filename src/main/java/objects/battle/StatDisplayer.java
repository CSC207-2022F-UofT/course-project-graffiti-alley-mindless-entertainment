package objects.battle;

import io.Output;
import io.OutputHandler;
import objects.character.EnemyFighter;
import objects.character.Player;
import objects.inventory.Inventory;

import java.util.List;

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
    public void displayPostBar() {
        output.generateText(
                "--------------------------------------------------------------------------------\n"
        );
    }
    public void displayPreBar() {
        output.generateText(
                "\n--------------------------------------------------------------------------------"
        );
    }

    /**
     * Displays the stats of the user and the enemy.
     */
    public void displayStats(Player user, EnemyFighter foe) {
        displayPreBar();
        displayStats(foe);
        displayStats(user);
        displayPostBar();
    }
    public void displayStats(Player user) {
        String userStats = "Name: " + user.getName() +
                " | HP: " + user.getCurrHealth() +
                " | Speed: " + user.getSpeed() +
                " | Type: " + user.getSkillType();
        output.generateText("[PLAYER STATS] " + userStats + "\n");
    }
    public void displayStats(EnemyFighter foe) {
        String foeStats = "Name: " + foe.getName() +
                " | HP: " + foe.getHealth() +
                " | Speed: " + foe.getSpeed() +
                " | Type: " + foe.getType();
        output.generateText("[ENEMY STATS] " + foeStats + "\n");
    }
    public String skillStats(Skill skill) {
        return "Name: " + skill.getName() +
                " | DMG: " + skill.getDamage() +
                " | Speed: " + -skill.getLag() +
                " | Type: " + skill.getType();
    }
    public void displayStats(List<Skill> skillList) {
        int num = 1;
        displayPreBar();
        for (Skill skill : skillList) {
            String stats = "Skill " + num + " ~ " + skillStats(skill);
            output.generateText(stats + "\n");
            num++;
        }
        displayPostBar();
    }
    public void displayStats(Inventory inv) {
        String invString = inv.viewInventory();
        displayPreBar();
        output.generateText(invString);
        displayPostBar();
    }

}
