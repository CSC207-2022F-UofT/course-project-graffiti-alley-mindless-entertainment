package pause_menu.inventory;

import inventory.entities.Inventory;
import io.InputValidator;
import core.State;
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
        StringBuilder textToDisplay = new StringBuilder();
        if (inventory.getInventory().size() == 0){
            textToDisplay.append("There is no item in your inventory!\n");
        }
        else{
            textToDisplay.append("Inventory: \n\n");
            textToDisplay.append(inventory.viewInventory());
        }
        textToDisplay.append("\nCommands: \n\n" +
                "return: type 'return' inventory to return to the pause menu.\n" +
                "remove i: type 'remove i' (i is the i-th item in inventory) to remove item.\n");
        Output.getScreen().generateText(textToDisplay.toString());
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
            int itemIndex = Integer.parseInt(inputArray[1]);
            if (itemIndex >= inventory.getInventory().size()){
                Output.getScreen().generateText("Make sure you have the item!\n");
                return;
            }
            inventory.removeItem(Integer.parseInt(inputArray[1]));
            awaitingInput = false;
            Output.getScreen().generateText("The item is successfully removed!\n");
            return;
        }

        Output.getScreen().generateText("Please enter a valid command! e.g. 'return', 'remove 0'\n");
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
