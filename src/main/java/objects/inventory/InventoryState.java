package objects.inventory;

import interfaces.InputValidator;
import interfaces.State;
import objects.item.*;

/**
 * Use case to change inventory based on user input
 */
public class InventoryState implements State {
    /**
     * inventory: entity for inventory
     * isDone: whether the state is done
     * awaitingInput: whether the state is waiting for user input
     * viewInventoryCommand: user command when user want to see inventory
     * addItemCommand: user command when user want to add item
     * removeItemCommand: user command when user want to remove item
     * useItemCommand: user command when user want to use item
     * quitCommand: user command when user want to quit inventory
     */
    private Inventory inventory;
    private boolean isDone = false;
    private boolean awaitingInput = false;
    private final String viewInventoryCommand;
    private final String addItemCommand;
    private final String removeItemCommand;
    private final String useItemCommand;
    private final String quitCommand;

    /**
     * @param inventory inventory contains items
     */

    public InventoryState(Inventory inventory){

        this.inventory = inventory;
        this.quitCommand = "quit";
        this.viewInventoryCommand = "view";
        this.removeItemCommand = "remove";
        this.addItemCommand = "add";
        this.useItemCommand = "use";

    }

    /**
     * Executes when not awaiting input
     */
    @Override
    public void preInput() {
        awaitingInput = true;
        // use outputHandler to display choices of commands
    }

    /**
     * Executes when awaiting input from the user
     * @param input from the user
     *        Input with item should be like "use LEVEL 10 POTION"
     *        Input without items - "view", "quit"
     */
    @Override
    public void postInput(String input) {
        boolean success = false;
        if (input.length() == 4) {
            if (input.equals("quit")){
                success = true;
            }
            else if (input.equals("view")) {
                if (inventory.viewInventory().equals("")){
                    // no item in inventory
                    // use outputHandler to display inventory
                }
                else {
                    success = true;
                }
            }
        }
        else {
            String[] inputarr = input.split(" ");
            if (inputarr.length != 4){
                return;
            }
            String command = inputarr[0];
            String itemName = inputarr[1] + " " + inputarr[2] + " " + inputarr[3];
            if (command.equals("remove")) {
                success = inventory.removeItem(itemName);
            } else if (command.equals("add")) {
                Item item = inputToItem(Integer.parseInt(inputarr[2]), inputarr[3]);
                success = inventory.addItem(item);
            } else if (command.equals("use")) {
                if (inventory.checkItem(itemName)) {
                    //send the ability to battle system????
                    inventory.useItem(itemName);
                    success = true;
                }
            }
        }


        if (success) {
            // use outputHandler to display success
            awaitingInput = false;
            isDone = true;
        }
        else{
            // use outputHandler to display fail
        }
    }



    /**
     * Initiate an item based on level and type
     * @param level level of item
     * @param type type of item
     * @return
     */
    public Item inputToItem(int level, String type) {
        Item item = null;
        if (type.equals("SWORD")) {
            item = new Sword(level);
        } else if (type.equals("ARMOR")) {
            item = new Armor(level);
        } else if (type.equals("POTION")) {
            item = new Potion(level);
        }
        return item;
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
