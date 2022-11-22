package objects.inventory;

import io.InputValidator;
import interfaces.State;
import objects.item.*;
import objects.character.Player;

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
    private Player player;
    private boolean isDone = false;
    private boolean awaitingInput = false;
    private final String addItemCommand;
    private final String removeItemCommand;
    private final String useItemCommand;
    private final String quitCommand;

    /**
     * @param inventory inventory contains items
     */
    public InventoryState(Inventory inventory, Player player){

        this.inventory = inventory;
        this.player = player;
        this.quitCommand = "quit";
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
        // use outputHandler to display inventory, call inventory.viewInventory()
        // use outputHandler to display choices of commands below
        // Commands:
        // Use item: type "use i" ("i" is the i-th item in inventory)
        // Remove item: type "remove i" ("i" is the i-th item in inventory)
        // Add item: type "add itemType" (itemType: Sword, Potion, Armor)
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
        }
        boolean success = false;
        if (command.length() == 2) {
            if (command.equals(removeItemCommand)) {
                success = inventory.removeItem(Integer.parseInt(inputarr[1]));
//            } else if (command.equals(addItemCommand)) {
//                Item item = inputToItem(player.getLevel(), inputarr[1]);
//                success = inventory.addItem(item);
//                if (!success){
//                    // say inventory is full
//                }
            } else if (command.equals(useItemCommand)) {
                String ability = inventory.useItem(Integer.parseInt(inputarr[1]));
                if (ability != null){
                    success = true;
                    // return the ability to battle system
                }
            }
        }
        if (success){
            // say success
            awaitingInput = false;
        }
        else {
            // say input invalid
        }
    }

    /**
     * Initiate an item based on level and type
     * @param level level of player
     * @param type type of item
     * @return Item created by level and type
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
