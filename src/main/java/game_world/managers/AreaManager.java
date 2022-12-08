package game_world.managers;

import core.StateManager;
import game_world.factories.DialogueStateFactory;
import game_world.factories.SelectionStateFactory;
import game_world.objects.Area;
import game_world.objects.Location;
import interfaces.State;
import io.Output;
import io.OutputHandler;

public class AreaManager extends StateManager {

    /**
     * Manages all matters regarding Areas
     */

    private final DialogueStateFactory dialogueStateFactory = new DialogueStateFactory();
    private final SelectionStateFactory selectionStateFactory = new SelectionStateFactory();
    private final AreaDatabaseInteractor databaseController;
    private final EventManager eventManager;
    private Area currentArea;
    private final Location location;

    public AreaManager(EventManager eventManager, Location location) {
        this.eventManager = eventManager;
        this.databaseController = new AreaDatabaseInteractor(this.eventManager);
        this.currentArea = databaseController.loadArea("0");
        this.location = location;
        this.location.setDatabaseController(databaseController);
    }

    @Override
    public void initialize() {
        this.currState = dialogueStateFactory.createDialogueState(this.currentArea);
        getToNextArea("1");
        this.location.setCurrentArea(this.currentArea);
    }

    /**
     * @param input current valid input from the user
     * @return next State depending on the current State
     */
    @Override
    protected State nextState(String input) {
        OutputHandler output = Output.getScreen();
        if (this.currentArea.getCurrTextIndex() == 0) {
            // Texts have initialized
            output.generateText("◈ " + this.currentArea.getSpeaker() + " ◈");
            eventManager.areaEntered(this.currentArea);
        }
        if (this.currentArea.getCurrTextIndex() == this.currentArea.getTexts().size()) {
            // Texts are all completed
            if (eventManager.queueCleared()) {
                // Events are completed (or there are none)
                if (this.currentArea.getNextInputs().contains(input.toLowerCase())) {
                    // Player entered a valid area to go next
                    getToNextArea(this.currentArea.getAreaFromInput(input.toLowerCase()));
                    output.generateText("You approach " + this.currentArea.getName() + " in " + this.currentArea.getZone() + ".");
                    return nextState(input);
                }
                else {
                    // Player selects an area to go next
                    this.currState = selectionStateFactory.createSelectionState(this.currentArea.getNextInputs());
                }
                return this.currState;
            }
            else {
                this.currentArea.setCurrEventIndex(this.currentArea.getCurrTextIndex() + 1);
                State nextState = eventManager.getNextStateInQueue();
                if (nextState != null)
                    return nextState;
                return nextState(input);
            }
        }
        else {
            // Next text in sequence to be played
            this.currState = dialogueStateFactory.createDialogueState(this.currentArea);
        }
        return this.currState;
    }

    /**
     * @return currentArea of Player
     */
    public Area getCurrentArea() {
        return this.currentArea;
    }

    /**
     * Changes current area to next loaded area from id
     * @param id of Area to be loaded and changed to
     */
    public void getToNextArea(String id) {
        // save events and data here
        assert this.currentArea.getNextAreas().contains(id);
        this.currentArea = databaseController.loadArea(id);
        this.location.setCurrentArea(this.currentArea);
    }

}
