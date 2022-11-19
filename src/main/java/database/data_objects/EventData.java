package database.data_objects;

public class EventData {

    /**
     * All information needed for an arbitrary event
     */

    public String name;
    public String type;
    public int priority;

    public EventData(String name, String type, int priority) {
        this.name = name;
        this.type = type;
        this.priority = priority;
    }
}

