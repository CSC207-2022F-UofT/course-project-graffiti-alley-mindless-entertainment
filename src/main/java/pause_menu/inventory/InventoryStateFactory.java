package pause_menu.inventory;

import core.State;
import inventory.entities.Inventory;

/**
 * Factory design pattern, used to create an inventory menu state, and avoid introducing the Inventory dependency.
 */
public class InventoryStateFactory {
    private final Inventory inventory;


    public InventoryStateFactory(Inventory inventory) {
        this.inventory = inventory;
    }

    public State createInventoryMenuState() {
        return new InventoryState(inventory);
    }
}
