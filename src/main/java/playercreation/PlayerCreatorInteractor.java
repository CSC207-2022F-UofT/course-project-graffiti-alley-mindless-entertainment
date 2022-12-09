package playercreation;

import objects.character.Player;
import objects.battle.skills.SkillType;

/**
 * A use case for creating a new Player character at the start of the game. PlayerCreatorManager utilizes this
 * class to store user input until a new Player can be created and stored in the database.
 */
public class PlayerCreatorInteractor {
    /**
     * newPlayer: The Player being created.
     *
     */

    private final Player newPlayer;

    /**
     * Initializes a new PlayerCreatorInteractor with player.
     */
    public PlayerCreatorInteractor(Player player) {
        this.newPlayer = player;
    }

    /**
     * @return The new Player being created.
     */
    public Player getNewPlayer() {
        return this.newPlayer;
    }

    /**
     * Change newPlayer's name to name.
     * @param name The new name to give to newPlayer.
     */
    public void addName(String name) {
        this.newPlayer.changeName(name);
    }

    /**
     * Change newPlayer's description to description.
     * @param description The new description to give to newPlayer.
     */
    public void addDescription(String description) {
        this.newPlayer.changeDescription(description);
    }

    /**
     * Change newPlayer's SkillType to skillType.
     * @param skillType The new SkillType to give to newPlayer.
     */
    public void addSkillType(SkillType skillType) {
        this.newPlayer.changeSkillType(skillType);
    }

}
