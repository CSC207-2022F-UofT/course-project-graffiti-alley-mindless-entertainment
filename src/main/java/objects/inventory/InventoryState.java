package objects.inventory;

import io.InputValidator;
import interfaces.State;

/**
 * Use case to change inventory based on user input
 */
public class InventoryState implements State {
    /**
     * inventory: entity for inventory
     * isDone: whether the state is done
     * awaitingInput: whether the state is waiting for user input
     * addItemCommand: user command when user want to add item
     * removeItemCommand: user command when user want to remove item
     * useItemCommand: user command when user want to use item
     * quitCommand: user command when user want to quit inventory
     */
    private Inventory inventory;
    private boolean isDone = false;
    private boolean awaitingInput = false;
    private final String removeItemCommand;

    private final String quitCommand;

    /**
     * @param inventory inventory contains items
     */
    public InventoryState(Inventory inventory){

        this.inventory = inventory;
        this.quitCommand = "quit";
        this.removeItemCommand = "remove";
    }

    /**
     * Executes when not awaiting input
     */
    @Override
    public void preInput() {
        awaitingInput = true;
        // use outputHandler to display inventory, call inventory.viewInventory()
        // use outputHandler to display choices of commands below
        // Commands:
        // Quit: quit inventory
        // Remove item: type "remove i" ("i" is the i-th item in inventory)
    }

    /**
     * Executes when awaiting input from the user
     * @param input from the user
     */
    @Override
    public void postInput(String input) {
        String[] inputarr = input.split(" ");
        String command = inputarr[0];
        if (command.equals(quitCommand)) {
            isDone = true;
            return;
        } else if (command.equals(removeItemCommand)) {
            inventory.removeItem(Integer.parseInt(inputarr[1]));
            awaitingInput = false;
            // say success
            return;
        }

        // say input invalid
    }

    /**
     * @return whether state is waiting input
     */
    @Override
    public boolean awaitInput() {
        return awaitingInput;
    }

    /**
     * @return whether state needs an input
     */
    @Override
    public boolean isDone() {
        return isDone;
    }

    /**
     * @return the input validator for accepted inputs
     */
    @Override
    public InputValidator getInputValidator() {
        return null;
    }
}
