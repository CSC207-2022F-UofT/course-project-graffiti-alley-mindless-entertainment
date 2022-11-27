package game_world.factories;

import game_world.validators.objects.states.DialogueState;

public class DialogueStateFactory {
    /** A factory class for creating new DialogueState. Used to avoid dependencies in AreaManager.
     */

    public DialogueState createDialogueState(String dialogue) {
        // Returns a new DialogueState.
        return new DialogueState(dialogue);
    }
}
