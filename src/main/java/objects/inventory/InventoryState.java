package objects.inventory;

import io.InputValidator;
import interfaces.State;
import io.Output;
/**
 * Use case to change inventory based on user input
 */
public class InventoryState implements State {
    /**
     * inventory: entity for inventory
     * isDone: whether the state is done
     * awaitingInput: whether the state is waiting for user input
     * removeItemCommand: user command when user want to remove item
     * quitCommand: user command when user want to quit inventory
     */
    private final Inventory inventory;
    private boolean isDone = false;
    private boolean awaitingInput = false;
    private final String removeItemCommand;
    private final String quitCommand;

    /**
     * @param inventory inventory contains items
     */
    public InventoryState(Inventory inventory){
        this.inventory = inventory;
        this.quitCommand = "return";
        this.removeItemCommand = "remove";
    }

    /**
     * Executes when not awaiting input
     */
    @Override
    public void preInput() {
        awaitingInput = true;
        String textToDisplay = inventory.viewInventory() + "Commands: \n" +
                "return: type 'return' inventory to return to the pause menu.\n" +
                "remove i: type 'remove i' (i is the i-th item in inventory) to remove item.\n";
        Output.getScreen().generateText(textToDisplay);
    }

    /**
     * Executes when awaiting input from the user
     * @param input from the user
     */
    @Override
    public void postInput(String input) {
        String[] inputArray = input.split(" ");
        String command = inputArray[0];
        if (command.equals(quitCommand)) {
            isDone = true;
            return;
        } else if (command.equals(removeItemCommand)) {
            inventory.removeItem(Integer.parseInt(inputArray[1]));
            awaitingInput = false;
            Output.getScreen().generateText("The item is successfully removed!");
            return;
        }

        Output.getScreen().generateText("Please enter a valid command! e.g. 'return', 'remove 0'");
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
