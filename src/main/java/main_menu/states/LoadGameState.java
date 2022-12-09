package main_menu.states;

import core.State;
import io.InputValidator;
import io.Output;
import io.OutputHandler;
import main_menu.input_validators.LoadGameInputValidator;
import save.use_cases.SaveInteractor;
import core.switch_managers.switch_events.SwitchEventMediator;
import core.switch_managers.switch_events.SwitchEventMediatorProxy;
import core.switch_managers.switch_events.SwitchEventType;

/**
 * The State for loading a previous game.
 */
public class LoadGameState implements State {
    /**
     * awaitInput: A boolean describing if the state is awaiting input.
     * isDone: A boolean describing if the state is done running the postInput process.
     * inputValidator: A LoadGameInputValidator that is used to validate the input from the user.
     * saveInteractor: A SaveInteractor used to load and display a maximum of 3 save slots.
     */
    private boolean awaitInput;
    private boolean isDone;
    private final SaveInteractor saveInteractor;
    private final LoadGameInputValidator inputValidator;

    /**
     * Initializes a new LoadGameState that is not completed and is not awaiting input.
     * @param saveInteractor The SaveInteractor for this LoadGameState.
     */
    public LoadGameState(SaveInteractor saveInteractor) {
        this.awaitInput = false;
        this.isDone = false;
        this.saveInteractor = saveInteractor;
        this.inputValidator = new LoadGameInputValidator(this.saveInteractor);
    }

    /**
     * Asks the user which save slot they would like to open, or if they would like to return to the main menu.
     * Utilizes OutputHandler.
     */
    @Override
    public void preInput() {
        this.awaitInput = true;
        OutputHandler output = Output.getScreen();
        output.generateText("You are currently attempting to load a save file.");
        output.generateText(saveInteractor.getSlotsStatus());
        output.generateText("Type the number of the save file to load it.");
        output.generateText("Type 'return' if you would like to return to the main menu.");
    }

    /**
     * Assumes input has already been parsed and validated.
     * @param input From the user.
     * Executes when the state is awaiting input.
     */
    @Override
    public void postInput(String input) {
        if (!(input.equalsIgnoreCase("return"))) {
            int slot = Integer.parseInt(input);
            if (this.saveInteractor.loadFromSlot(slot)) {
                SwitchEventMediatorProxy.getInstance().store(SwitchEventType.LOAD_GAME);
            }
            else {
                // Switches to the PlayerCreatorManager to start a new game.
                SwitchEventMediator mediator = SwitchEventMediatorProxy.getInstance();
                mediator.store(SwitchEventType.NEW_GAME);
            }
        }

        this.awaitInput = false;
        this.isDone = true;
    }

    /**
     * @return Boolean awaitInput.
     */
    @Override
    public boolean awaitInput() {
        return this.awaitInput;
    }

    /**
     * @return Boolean isDone.
     */
    @Override
    public boolean isDone() {
        return this.isDone;
    }

    /**
     * @return The LoadGameInputValidator of this LoadGameState.
     */
    @Override
    public InputValidator getInputValidator() {
        return this.inputValidator;
    }
}
