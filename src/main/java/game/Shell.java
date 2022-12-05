package game;

import core.StateManager;
import switch_managers.SwitchEventMediator;
import switch_managers.SwitchEventType;
import switch_managers.ManagerController;
import io.InputHandler;

/**
 * This class contains the shell, which connects the different systems of the program together.
 */
public class Shell {
    /**
     * Attributes.
     */
    private StateManager currentManager;

    private final ManagerController managerController;
    private final InputHandler inputHandler;

    private final SwitchEventMediator switchEventMediator;
    private boolean running;
    private boolean saveLoaded;

    public Shell(InputHandler inputHandler, ManagerController managerController, StateManager startingManager, SwitchEventMediator switchEventMediator) {
        this.inputHandler = inputHandler;
        this.managerController = managerController;
        this.currentManager = startingManager;
        this.switchEventMediator = switchEventMediator;
        this.saveLoaded = false;
    }


    /**
     * Starts the game,
     */
    public void startGame() {
        running = true;

        mainLoop();
    }

    /**
     * Main method running the whole game.
     */
    private void mainLoop() {
        // The game runs until the User decides to exit the game.
        while (running) {

            if (switchEventMediator.ready()) {
                switchManager();
                continue;
            }

            //!!! everything below need to be worked on!
            if (currentManager.awaitInput()) {
                String input = inputHandler.getChoice(currentManager.getInputValidator());
                if (detectedMenuInput(input)) continue;
                currentManager.postInput(input);
            } else {
                currentManager.preInput();
            }
        }
    }
    /**
     * @param input from the user
     * @return whether the user entered a menu command like exit/pause
     */
    private boolean detectedMenuInput(String input) {
        if (doesUserExit(input)) {
            if (saveLoaded) {
                switchEventMediator.store(SwitchEventType.MAIN_MENU);
            }
            else {
                exitGame();
            }
            return true;
        } else if (doesUserPause(input)) {
            if (saveLoaded) {
                switchEventMediator.store(SwitchEventType.PAUSE);
            }
            else {
                currentManager.preInput();
            }
            return true;
        }
        return false;
    }

    /**
     * Exit the game cleanly.
     */
    private void exitGame() {
        running = false;
        //do smth here like saving data to files to be implemented later
    }

    /**
     * Handles the system to switch between the different managers in the game.
     * (!!!)
     */
    private void switchManager() {
        // !!! get switch event somehow - maybe through a mediator?
        SwitchEventType switchEventType = switchEventMediator.retrieve();

        if (switchEventType == SwitchEventType.START_GAME || switchEventType == SwitchEventType.LOAD_GAME) {
            this.saveLoaded = true;
        }
        else if (switchEventType == SwitchEventType.MAIN_MENU) {
            this.saveLoaded = false;
        }

        if (switchEventType == SwitchEventType.END_GAME) {
            if (!this.saveLoaded) {
                exitGame();
            }
            else {
                this.currentManager = managerController.switchManagers(SwitchEventType.MAIN_MENU, currentManager);
            }
        }

        this.currentManager = managerController.switchManagers(switchEventType, currentManager);
        if (currentManager.isDone()) {
            currentManager.initialize();
        }
    }

    /**
     * Checks whether the user wants to exit the game.
     * Returns true, if userInput is equal to "exit". Otherwise, returns false.
     */
    // !!! not exactly sure how to connect this to menus & MenuType.
    private boolean doesUserExit(String userInput) {
        return userInput.equalsIgnoreCase("exit");
    }

    /**
     * Checks whether the user wants to pause the game.
     * Returns true, if userInput equals "pause". Otherwise, returns false.
     */
    //!!! not exactly sure how to connect this to menus & MenuType.
    private boolean doesUserPause(String userInput) {
        return userInput.equalsIgnoreCase("pause");
    }
}
