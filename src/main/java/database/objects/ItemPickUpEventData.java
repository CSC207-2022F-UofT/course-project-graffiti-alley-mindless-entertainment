package database.objects;

public class ItemPickUpEventData {

    /**
     * All information needed for an item pick-up event
     */

    public String name;
    public String type;
    public String item;

    public ItemPickUpEventData(String name, String type, String item) {
        this.name = name;
        this.type = type;
        this.item = item;
    }

}

