package pause_menu.save;

import core.State;
import save.use_cases.SaveInteractor;

public class SaveMenuStateFactory {
    /**
     * saveInteractor: injected dependency for the saveInteractor to pass to SaveMenuState
     */
    private final SaveInteractor saveInteractor;

    public SaveMenuStateFactory(SaveInteractor saveInteractor) {
        this.saveInteractor = saveInteractor;
    }

    /**
     * Creates the save menu state.
     * @return the save menu state
     */
    public State createSaveMenuState() {
        return new SaveMenuState(saveInteractor);
    }
}
