package main_menu.factories;


import interfaces.State;
import main_menu.states.LoadGameState;
import main_menu.states.MainMenuState;
import main_menu.states.NewGameState;
import main_menu.states.QuitState;

public class MainMenuFactory {
    /** A factory class for creating new States from main_menu.states. Used to avoid dependencies in MainMenuManager.
     */

    public State createMainMenuState() {
        // Returns a new MainMenuState.
        return new MainMenuState();
    }

    public State createLoadGameState() {
        // Returns a new LoadGameState.
        return new LoadGameState();
    }

    public State createNewGameState() {
        // Returns a new NewGameState.
        return new NewGameState();
    }

    public State createQuitState() {
        // Returns a new QuitState.
        return new QuitState();
    }
}
