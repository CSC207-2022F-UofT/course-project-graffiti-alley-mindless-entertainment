package database.objects;

public class EventData {

    /**
     * All information needed for an arbitrary event
     */

    public String name;
    public String type;

    public String item;
    public String encounterType;
    public String npc;

    public EventData(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public EventData(String name, String type, String item) {
        this.name = name;
        this.type = type;
        this.item = item;
    }

    public EventData(String name, String type, String encounterType, String npc) {
        this.name = name;
        this.type = type;
        this.encounterType = encounterType;
        this.npc = npc;
    }
}

