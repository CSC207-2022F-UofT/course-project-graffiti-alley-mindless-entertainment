package menus;

import interfaces.State;
import managers.StateManager;
import menus.options.ChangeOptionsState;
import menus.options.ChangeOptionsStateFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


/**
 * Used to manage the different menus and states of the pause menu.
 */
public class PauseMenuManager extends StateManager {
    /**
     * currMenuType: an enum for the current state of the pauseMenu.
     * all other fields are extracted constants
     */

    private final List<String> pauseMenuOptions;
    private final String optionsCommand;

    private final String saveCommand;
    private final String exitCommand;

    private final PauseMenuChoiceStateFactory pauseMenuChoiceStateFactory;
    private final ChangeOptionsStateFactory changeOptionsStateFactory;

    private MenuType currMenuType;

    /**
     * @param pauseMenuChoiceStateFactory injected dependency
     * @param changeOptionsStateFactory injected dependency
     */
    public PauseMenuManager(PauseMenuChoiceStateFactory pauseMenuChoiceStateFactory,
                            ChangeOptionsStateFactory changeOptionsStateFactory) {
        this.pauseMenuChoiceStateFactory = pauseMenuChoiceStateFactory;
        this.changeOptionsStateFactory = changeOptionsStateFactory;
        this.optionsCommand = "options";
        this.saveCommand = "save";
        this.exitCommand = "quit";
        this.pauseMenuOptions = Arrays.asList(optionsCommand, saveCommand, exitCommand);

        initialize();
    }

    /**
     * In conjunction with pre and post input, switches the state of the manager.
     * @param input from the user
     * @return the next state
     */
    @Override
    public State nextState(String input) {

        if (currMenuType == MenuType.PAUSE) {
            if (Objects.equals(input, optionsCommand)) {
                currMenuType = MenuType.OPTIONS;
                return changeOptionsStateFactory.createChangeOptionsState();
            } else if (Objects.equals(input, saveCommand)) {
                currMenuType = MenuType.SAVE;
                //to be implemented later
                return null;
            } else {
                return null;
            }
        } else {
            if (Objects.equals(input, exitCommand)) {
                currMenuType = MenuType.PAUSE;
                return pauseMenuChoiceStateFactory.createPauseMenuChoiceState(pauseMenuOptions);
            }
        }

        return null;
    }

    /**
     * Called to initialize the state of the menuManager
     */
    @Override
    public void initialize() {
        currMenuType = MenuType.PAUSE;
        currState = pauseMenuChoiceStateFactory.createPauseMenuChoiceState(pauseMenuOptions);
    }
}
