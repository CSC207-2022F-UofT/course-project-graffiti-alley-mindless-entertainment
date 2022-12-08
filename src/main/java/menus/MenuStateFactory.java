package menus;

import core.ChoiceState;
import interfaces.State;
import menus.options.ChangeOptionsStateFactory;
import menus.save.SaveMenuStateFactory;
import objects.inventory.InventoryStateFactory;

import java.util.List;

/**
 * Uses facade design pattern to collate all the different factories.
 */
public class MenuStateFactory {

    /**
     * changeOptionsStateFactory: injected dependency to create changeOptionsState
     * inventoryStateFactory: injected dependency to create inventoryState
     * saveMenuStateFactory: injected dependency used to create saveMenuState
     */
    private final ChangeOptionsStateFactory changeOptionsStateFactory;
    private final InventoryStateFactory inventoryStateFactory;
    private final SaveMenuStateFactory saveMenuStateFactory;

    public MenuStateFactory(ChangeOptionsStateFactory changeOptionsStateFactory, InventoryStateFactory inventoryStateFactory, SaveMenuStateFactory saveMenuStateFactory) {
        this.changeOptionsStateFactory = changeOptionsStateFactory;
        this.inventoryStateFactory = inventoryStateFactory;
        this.saveMenuStateFactory = saveMenuStateFactory;
    }

    public State createChangeOptionsState() {
        return changeOptionsStateFactory.createChangeOptionsState();
    }

    /**
     * @param pauseOptions The options for the pause menu.
     * @return the pauseMenuChoiceState
     */
    public State createPauseMenuChoiceState(List<String> pauseOptions) {
        return new ChoiceState(pauseOptions, "What do you want to do?");
    }

    /**
     * Creates the inventory menu state.
     * @return the inventory menu state
     */
    public State createInventoryMenuState() {
        return inventoryStateFactory.createInventoryMenuState();
    }

    /**
     * Creates the save menu state.
     * @return the save menu state
     */
    public State createSaveMenuState() {return saveMenuStateFactory.createSaveMenuState();}
}
