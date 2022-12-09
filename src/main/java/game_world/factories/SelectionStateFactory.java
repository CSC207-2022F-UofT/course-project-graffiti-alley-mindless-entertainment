package game_world.factories;

import game_world.states.SelectionState;

import java.util.ArrayList;

public class SelectionStateFactory {

    /**
     * A factory class for creating new SelectionState. Used to avoid dependencies in AreaManager.
     */

    public SelectionState createSelectionState(ArrayList<String> inputs) {
        // Returns a new SelectionState.
        return new SelectionState(inputs);
    }
}
