package playercreation;

import objects.character.Player;
import objects.battle.SkillType;

public class PlayerCreatorInteractor {
    /** A use case for creating a new Player character at the start of the game. PlayerCreatorManager utilizes this
     * class to store user input until a new Player can be created and stored in the database.
     * Attributes:
     * newPlayer: The Player being created.
     */

    private final Player newPlayer;

    public PlayerCreatorInteractor() {
        // Initializes a new PlayerCreatorInteractor with Player having an empty string for name and null for
        // SkillType.
        this.newPlayer = new Player("", null);
    }

    public Player getNewPlayer() {
        // Return the new Player being created.
        return this.newPlayer;
    }

    public void addName(String name) {
        // Change the Player's name to name.
        this.newPlayer.changeName(name);
    }

    public void addDescription(String description) {
        // Change the Player's description to description.
        this.newPlayer.changeDescription(description);
    }

    public void addSkillType(SkillType skillType) {
        // Change the Player's skillType to skillType.
        this.newPlayer.changeSkillType(skillType);
    }

    public boolean savePlayer() {
        // Saves the completed Player character to the database. Returns true if the process is completed successfully.
        // Awaiting saving functionality.
        return true;
    }

}
