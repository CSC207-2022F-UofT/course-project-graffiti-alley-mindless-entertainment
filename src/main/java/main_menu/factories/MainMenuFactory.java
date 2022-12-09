package main_menu.factories;


import core.State;
import main_menu.states.LoadGameState;
import main_menu.states.MainMenuState;
import main_menu.states.NewGameState;
import save.use_cases.SaveInteractor;

/** A factory class for creating new States from main_menu.states. Used to avoid dependencies in MainMenuManager.
 */
public class MainMenuFactory {
    /**
     * saveInteractor: The SaveInteractor for this MainMenuFactory. Passes it to the States for further use if
     *                 applicable.
     */
    private final SaveInteractor saveInteractor;

    /**
     * Initializes a new MainMenuFactory
     * @param saveInteractor The SaveInteractor for this factory to pass to a State if applicable.
     */
    public MainMenuFactory(SaveInteractor saveInteractor) { this.saveInteractor = saveInteractor; }
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
        return new LoadGameState(this.saveInteractor);
    }

    /**
     * @return A new NewGameState.
     */
    public State createNewGameState() {
        return new NewGameState();
    }
}
