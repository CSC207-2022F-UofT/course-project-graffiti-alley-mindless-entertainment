package database.entities;

public class ItemPickUpEventData {

    /**
     * All information needed for an item pick-up event
     */

    public String name;
    public String type;
    public String item;
    public String text;

    public ItemPickUpEventData(String name, String type, String item, String text) {
        this.name = name;
        this.type = type;
        this.item = item;
        this.text = text;
    }

}

