package game_world.managers;

import core.StateManager;
import game_world.factories.DialogueStateFactory;
import game_world.factories.SelectionStateFactory;
import game_world.objects.Location;
import interfaces.State;

public class AreaManager extends StateManager {

    /**
     * Manages all matters regarding Areas
     */

    private final DialogueStateFactory dialogueStateFactory = new DialogueStateFactory();
    private final SelectionStateFactory selectionStateFactory = new SelectionStateFactory();
    private final EventManager eventManager;
    private final AreaUseCase areaUseCase;

    public AreaManager(EventManager eventManager, Location location) {
        this.eventManager = eventManager;
        this.areaUseCase = new AreaUseCase(new AreaDatabaseInteractor(eventManager), location);
        areaUseCase.getToNextArea("0");
    }

    @Override
    public void initialize() {
        this.currState = dialogueStateFactory.createDialogueState(areaUseCase.getCurrentArea());
        areaUseCase.getToNextArea("1");
    }

    /**
     * @param input current valid input from the user
     * @return next State depending on the current State
     */
    @Override
    protected State nextState(String input) {
        if (areaUseCase.checkForAreaEntered()) {
            eventManager.areaEntered(areaUseCase.getCurrentArea());
            this.currState = dialogueStateFactory.createDialogueState(areaUseCase.getCurrentArea());

            return this.currState;
        }

        if (eventManager.queueCleared()) {
            if (areaUseCase.checkForValidInput(input)) {
                areaUseCase.arriveAtNextArea(input);
                return nextState(input);
            }
            else {
                this.currState = selectionStateFactory.createSelectionState(areaUseCase.getNextInputs());
            }
            return this.currState;
        }
        else {
            areaUseCase.updateEventIndex();
            State nextEvent = eventManager.getNextStateInQueue();

            if (nextEvent != null)
                return nextEvent;

            assert eventManager.queueCleared();
            return nextState(input);
        }
    }

    /**
     * Testing purposes
     * @return current areaUseCase
     */
    public AreaUseCase getAreaUseCase() {
        return areaUseCase;
    }

}
