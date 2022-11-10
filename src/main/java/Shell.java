/**
 * This class contains the Shell.
 */
public class Shell {
    /**
     * Attributes.
     */
    //!!! description
    private StateManager currentManager;
    //!!! description – should it be private?
    private InputHandler inputHandler;
    //!!! description – should it be private?
    private OutputHandler outputHandler;


    /**
     * Main method containing the whole game.
     * !!! Additional description will be needed
     */
    public void main(String[] args) {
        // The game runs until the User decides to exit the game.
        // !!! shouldn't another condition be that the player looses? or there is no way he can lose?
        // !!! and he gets to start over and over
        while (! this.didUserExit()) {
            //!!! everything below need to be worked on!

            currentManager.preInput();
            currentManager.postInput();

            this.switchingManager();
        }
    }

    /**
     * Handles the system to switch between the different managers in the game & the different modules of the game
     * (!!!)
     */
    //!! Need to create the system when more managers within the game are created.
    public void switchingManager() {

    }

    /**
     * Checks whether the user exited the game.
     */
    //!!! Are parameters needed?
    public boolean didUserExit() {
        //!!! Add if statement and get the user's input here.
        return false;
    }
}
