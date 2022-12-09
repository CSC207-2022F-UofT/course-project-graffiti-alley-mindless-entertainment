package database.entities;

public class ItemPickUpEventData {

    /**
     * All information needed for an item pick-up event
     */

    public final String name;
    public final String type;
    public final String item;
    public final String text;

    public ItemPickUpEventData(String name, String type, String item, String text) {
        this.name = name;
        this.type = type;
        this.item = item;
        this.text = text;
    }

}

