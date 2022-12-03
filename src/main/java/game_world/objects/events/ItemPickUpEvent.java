package game_world.objects.events;

import game_world.WorldInputValidator;
import game_world.factories.ItemFactory;
import io.InputValidator;
import io.Output;
import objects.character.Player;
import objects.inventory.Inventory;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemPickUpEvent extends Event {

    /**
     * Event executes when there is an item to be picked up (to be implemented)
     */

    private final String item;
    private final WorldInputValidator inputValidator;
    private boolean isDone;
    private boolean awaitInput;

    // change below for inputs u want
    private final ArrayList<String> inputs = new ArrayList<String>(Arrays.asList(
            "yes", "no"
    ));
    public Inventory inventory;
    private final int maxSize = 5;
    public String text;

    public ItemPickUpEvent(String name, String item, String text) {
        this.name = name;
        this.type = "Item Pick-Up";
        this.item = item;
        this.inputValidator = new WorldInputValidator(inputs);
        this.awaitInput = false;
        this.isDone = false;
        this.inventory = Player.getInventory();
        this.text = text;
    }

    @Override
    public void preInput() {
        this.awaitInput = true;
        StringBuilder textToDisplay = new StringBuilder("[ITEM PICK-UP EVENT] " + this.text);
        textToDisplay.append("\n Do you want to pick up the item?");
        for (String input : inputs) {
            textToDisplay.append("\t◈ ").append(input).append("\n");
        }
        Output.getScreen().generateText(textToDisplay.toString());
    }

    @Override
    public void postInput(String input) {
        boolean success = false;
        this.awaitInput = false;
        this.isDone = true;

        if (input.equals("yes")){
            switch (this.item) {
                case "Sword":
                    success = inventory.addItem(ItemFactory.createItem("Sword"));
                    break;
                case "Armor":
                    success = inventory.addItem(ItemFactory.createItem("Armor"));
                    break;
                case "Potion":
                    success = inventory.addItem(ItemFactory.createItem("Potion"));
                    break;
            }

            if (success){
                Output.getScreen().generateText("The item is added to your inventory.");
            }
            else{
                Output.getScreen().generateText("Your inventory is full. You cannot pick up the item.");
            }
        }
        else if (input.equals("no")){
            Output.getScreen().generateText("You decided not to pick up the item.");
        }
    }

    @Override
    public boolean awaitInput() {
        return this.awaitInput;
    }

    @Override
    public boolean isDone() {
        return this.isDone;
    }

    @Override
    public InputValidator getInputValidator() {
        return this.inputValidator;
    }
}
