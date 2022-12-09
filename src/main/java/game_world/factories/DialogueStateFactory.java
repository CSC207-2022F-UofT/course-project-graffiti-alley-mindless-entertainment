package game_world.factories;

import game_world.entities.Area;
import game_world.states.DialogueState;

public class DialogueStateFactory {

    /**
     * A factory class for creating new DialogueState. Used to avoid dependencies in AreaManager.
     */

    public DialogueState createDialogueState(Area currentArea) {
        // Returns a new DialogueState.
        return new DialogueState(currentArea);
    }
}
