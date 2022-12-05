package menus;

import menus.options.ChangeOptionsStateFactory;
import options.Options;
import org.junit.jupiter.api.Test;

class PauseMenuManagerTest {

    @Test
    void changeOptionsAndQuit() {
        Options options = Options.getOptions();
        PauseMenuChoiceStateFactory pauseMenuChoiceStateFactory = new PauseMenuChoiceStateFactory();
        ChangeOptionsStateFactory changeOptionsStateFactory = new ChangeOptionsStateFactory();
        PauseMenuManager pauseMenuManager = new PauseMenuManager(pauseMenuChoiceStateFactory, changeOptionsStateFactory);
        pauseMenuManager.initialize();
        pauseMenuManager.preInput();
        pauseMenuManager.postInput("options");

        pauseMenuManager.preInput();
        pauseMenuManager.postInput("change autoSave false");

        assert(!options.isEnableAutoSave());
        assert(!pauseMenuManager.isDone());
        pauseMenuManager.preInput();
        pauseMenuManager.postInput("return");
        assert(!pauseMenuManager.isDone());
        pauseMenuManager.preInput();
        pauseMenuManager.postInput("return");
        assert(pauseMenuManager.isDone());
    }
}