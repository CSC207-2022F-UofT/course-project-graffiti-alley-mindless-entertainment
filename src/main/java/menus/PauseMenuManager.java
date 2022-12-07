package menus;

import interfaces.State;
import core.StateManager;
import switch_managers.SwitchEventMediatorProxy;
import switch_managers.SwitchEventType;

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

    private final String inventoryCommand;
    private final String questCommand;
    private final MenuStateFactory menuStateFactory;

    private MenuType currMenuType;

    /**
     * @param menuStateFactory injected dependency
     */
    public PauseMenuManager(MenuStateFactory menuStateFactory) {
        this.menuStateFactory = menuStateFactory;
        this.optionsCommand = "options";
        this.inventoryCommand = "inventory";
        this.questCommand = "quest";
        this.saveCommand = "save";
        this.exitCommand = "return";
        this.pauseMenuOptions = Arrays.asList(optionsCommand, inventoryCommand, saveCommand, exitCommand);

        initialize();
    }

    /**
     * In conjunction with pre and post input, switches the state of the manager.
     * @param input from the user
     * @return the next state
     */
    @Override
    protected State nextState(String input) {

        if (currMenuType == MenuType.PAUSE) {
            if (Objects.equals(input, optionsCommand)) {
                currMenuType = MenuType.OPTIONS;
                return menuStateFactory.createChangeOptionsState();
            } else if (Objects.equals(input, saveCommand)) {
                currMenuType = MenuType.SAVE;
                //to be implemented later
                return null;
            } else if (Objects.equals(input, questCommand)) {
                currMenuType = MenuType.QUEST;
                //to be implemented later
                return null;
            } else if (Objects.equals(input, inventoryCommand)) {
                currMenuType = MenuType.INVENTORY;
                return menuStateFactory.createInventoryMenuState();
            } else {
                SwitchEventMediatorProxy.getInstance().store(SwitchEventType.RESUME);

                return null;
            }
        } else {
            if (Objects.equals(input, exitCommand)) {
                currMenuType = MenuType.PAUSE;
                return menuStateFactory.createPauseMenuChoiceState(pauseMenuOptions);
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
        currState = menuStateFactory.createPauseMenuChoiceState(pauseMenuOptions);
    }
}
