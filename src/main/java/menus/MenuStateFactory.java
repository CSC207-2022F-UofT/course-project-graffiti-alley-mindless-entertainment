package menus;

import core.ChoiceState;
import interfaces.State;
import menus.options.ChangeOptionsStateFactory;
import objects.inventory.InventoryStateFactory;

import java.util.List;

/**
 * Uses facade design pattern to collate all the different factories.
 */
public class MenuStateFactory {

    private final ChangeOptionsStateFactory changeOptionsStateFactory;
    private final InventoryStateFactory inventoryStateFactory;

    public MenuStateFactory(ChangeOptionsStateFactory changeOptionsStateFactory, InventoryStateFactory inventoryStateFactory) {
        this.changeOptionsStateFactory = changeOptionsStateFactory;
        this.inventoryStateFactory = inventoryStateFactory;
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

    public State createInventoryMenuState() {
        return inventoryStateFactory.createInventoryMenuState();
    }
}
