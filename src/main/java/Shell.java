import core.StateManager;
import io.InputHandler;
import io.OutputHandler;

/**
 * This class contains the shell, which connects the different systems of the program together.
 */
public class Shell {
    /**
     * Attributes.
     */
    private StateManager currentManager;
    private InputHandler inputHandler;
    private OutputHandler outputHandler;

    /**
     * Main method running the whole game.
     */
    public void main(String[] args) {
        // !!! should there be another statement here that calls method to initialize the game?
        this.currentManager = getStartingManager();

        // !!! not calling the right input for condition
        // !!! should it simply be already creating the string like below her
        // and then update if in the first if statement of the loop.
        while (this.doesUserStopGame("")) {
            if (this.currentManager.awaitInput()) {
                String input = this.inputHandler.getChoice(this.currentManager.getInputValidator());

                // !!! Not sure how to call the pause menu manager and how this works.

                this.currentManager.postInput(input);
            } else {
                this.currentManager.preInput();
            }
            if (this.currentManager.isDone()) {
                switchManager();
            }
        }

    }

    //!!! Shouldn't there be the creation of game method?
    // private void createStarterGame()

    /**
     * Returns the manager for the start of the game.
     */
    // !!! not sure that I got who the first manager is and how this part works.
    public StateManager getStartingManager() {
        return null;
    }

    /**
     * Handles the system to switch between the different managers in the game.
     * (!!!)
     */
    //!! Need to create the system when more managers within the game are created.
    private void switchManager() {
        // !!! should assign the nextManager to this.currentManager.

    }

    /**
     * Checks whether the user wants to exit the game.
     * Returns true, if userInput is equal to "exit". Otherwise, returns false.
     */
    // !!! not exactly sure how to connect this to menus & MenuType.
    private boolean doesUserExit(String userInput) {
        return userInput.toLowerCase() == "exit";
    }

    /**
     * Checks whether the user wants to pause the game.
     * Returns true, if userInput equals "pause". Otherwise, returns false.
     */
    //!!! not exactly sure how to connect this to menus & MenuType.
    private boolean doesUserPause(String userInput) {
        return userInput.toLowerCase() == "pause";
    }

    /**
     * Checks whether the user wants to save the game.
     * Returns true, if userInput equals "save". Otherwise, returns false.
     */
    //!!! not exactly sure how to connect this to menus & MenuType.
    private boolean doesUserSave(String userInput) {
        return userInput.toLowerCase() == "save";
    }

    /**
     * Returns true if player wants to pause, save or exit the game.
     */
    private boolean doesUserStopGame(String userInput) {
        return doesUserExit(userInput) || doesUserPause(userInput) || doesUserSave(userInput);
    }
}
