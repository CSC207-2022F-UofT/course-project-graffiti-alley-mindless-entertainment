package game;

import core.StateManager;
import core.SwitchEventType;
import interfaces.ManagerController;
import io.InputHandler;
import playercreation.PlayerCreatorManager;

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
    private boolean running;

    public Shell(InputHandler inputHandler, ManagerController managerController) {
        this.inputHandler = inputHandler;
        this.managerController = managerController;
    }

    public void startGame() {
        currentManager = getStartingManager();
        running = true;
        //initialize all the managers

        mainLoop();
    }

    /**
     * Main method running the whole game.
     */
    private void mainLoop() {
        // The game runs until the User decides to exit the game.
        while (running) {
            //!!! everything below need to be worked on!
            if (currentManager.awaitInput()) {
                String input = inputHandler.getChoice(currentManager.getInputValidator());
                if (detectedMenuInput(input)) continue;
                currentManager.postInput(input);
            } else {
                currentManager.preInput();
            }

            if (currentManager.isDone()) {
                switchManager();
            }
        }
    }
    /**
     * @param input from the user
     * @return whether the user entered a menu command like exit/pause
     */
    private boolean detectedMenuInput(String input) {
        if (doesUserExit(input)) {
            exitGame();
            return true;
        } else if (doesUserPause(input)) {
            switchManager();
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

    //!!! Shouldn't there be the creation of game method?
    // private void createStarterGame()

    /**
     * Returns the manager for the start of the game.
     */
    // !!! not sure that I got who the first manager is and how this part works.
    private StateManager getStartingManager() {
        //should change to a mainMenuManager when one gets created
        PlayerCreatorManager playerCreatorManager = new PlayerCreatorManager();
        //playerCreatorManager.initialize();
        return playerCreatorManager;
    }

    /**
     * Handles the system to switch between the different managers in the game.
     * (!!!)
     */
    private void switchManager() {
        // !!! get switch event somehow - maybe through a mediator?
        SwitchEventType switchEventType = SwitchEventType.PAUSE;
        this.currentManager = managerController.switchManagers(switchEventType, currentManager);
        currentManager.initialize();
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
