package main_menu.factories;


import interfaces.State;
import main_menu.states.LoadGameState;
import main_menu.states.MainMenuState;
import main_menu.states.NewGameState;

/** A factory class for creating new States from main_menu.states. Used to avoid dependencies in MainMenuManager.
 */
public class MainMenuFactory {

    /**
     * Initializes a new MainMenuFactory
     */
    public MainMenuFactory() {}
    /**
     * @return A new MainMenuState.
     */
    public State createMainMenuState() {
        return new MainMenuState();
    }

    /**
     * @return A new LoadGameState.
     */
    public State createLoadGameState() {
        return new LoadGameState();
    }

    /**
     * @return A new NewGameState.
     */
    public State createNewGameState() {
        return new NewGameState();
    }
}
