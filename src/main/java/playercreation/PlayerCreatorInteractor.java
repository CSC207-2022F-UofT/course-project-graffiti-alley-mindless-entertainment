package playercreation;

public class PlayerCreatorInteractor {
    /** A use case for creating a new Player character at the start of the game. PlayerCreatorManager utilizes this
     * class to store user input until a new Player can be created and stored in the database.
     * Attributes:
     * newPlayer: The Player being created.
     */

    private int newPlayer;

    public PlayerCreatorInteractor() {
        // Initializes a new PlayerCreatorInteractor with an empty Player character.
        this.newPlayer = 0;
    }

    public void addName(String name) {
        // Change the Player's name to name.

    }

    public void addDescription(String description) {
        // Change the Player's description to description.

    }

    public void addSkillType(int skillType) {
        // Change the Player's skillType to skillType.

    }

    public boolean savePlayer() {
        // Saves the completed Player character to the database. Returns true if the process is completed successfully.
        return true;
    }

}
