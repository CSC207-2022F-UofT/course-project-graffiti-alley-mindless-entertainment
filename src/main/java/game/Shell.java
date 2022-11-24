package game;

import core.StateManager;
import io.InputHandler;
import io.OutputHandler;
import menus.PauseMenuChoiceStateFactory;
import menus.PauseMenuManager;
import menus.options.ChangeOptionsStateFactory;
import options.Options;

/**
 * This class contains the shell, which connects the different systems of the program together.
 */
public class Shell {
    /**
     * Attributes.
     */
    private StateManager currentManager;
    private InputHandler inputHandler;
    private boolean running;

    public Shell(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
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
        Options options = Options.getOptions();
        PauseMenuChoiceStateFactory pauseMenuChoiceStateFactory = new PauseMenuChoiceStateFactory();
        ChangeOptionsStateFactory changeOptionsStateFactory = new ChangeOptionsStateFactory();
        return new PauseMenuManager(pauseMenuChoiceStateFactory, changeOptionsStateFactory);
    }

    /**
     * Handles the system to switch between the different managers in the game.
     * (!!!)
     */
    //!! Need to create the system when more managers within the game are created.
    private void switchManager() {
        // !!! should assign the nextManager to this.currentManager.
        //should have some arguments
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
