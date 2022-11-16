package menus;

import interfaces.State;
import managers.StateManager;
import menus.options.ChangeOptionsState;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class PauseMenuManager extends StateManager {

    private List<String> pauseMenuOptions;
    private String optionsCommand;

    private String saveCommand;
    private String exitCommand;

    PauseMenuChoiceStateFactory pauseMenuChoiceStateFactory;

    MenuType currMenuType;

    public PauseMenuManager(PauseMenuChoiceStateFactory pauseMenuChoiceStateFactory) {
        this.pauseMenuChoiceStateFactory = pauseMenuChoiceStateFactory;
        this.optionsCommand = "options";
        this.saveCommand = "save";
        this.exitCommand = "exit";
        this.pauseMenuOptions = Arrays.asList(optionsCommand, saveCommand, exitCommand);

        currState = pauseMenuChoiceStateFactory.createPauseMenuChoiceState(pauseMenuOptions);
    }

    /**
     * @param input from the user
     * @return the next state
     */
    @Override
    public State nextState(String input) {

        if (currMenuType == MenuType.PAUSE) {
            if (Objects.equals(input, optionsCommand)) {
                return new ChangeOptionsState();
            } else if (Objects.equals(input, saveCommand)) {
                //to be implemented later
                return null;
            } else {
                return null;
            }
        } else {
            if (Objects.equals(input, exitCommand)) {
                return pauseMenuChoiceStateFactory.createPauseMenuChoiceState(pauseMenuOptions);
            }
        }

        return null;
    }

    /**
     *
     */
    @Override
    public void initialize() {
        currState = pauseMenuChoiceStateFactory.createPauseMenuChoiceState(pauseMenuOptions);
    }
}
