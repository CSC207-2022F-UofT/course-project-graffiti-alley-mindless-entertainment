package database.objects;

public class EventData {

    /**
     * All information needed for an arbitrary event
     */

    public String name;
    public String type;
    public long priority;

    public EventData(String name, String type, long priority) {
        this.name = name;
        this.type = type;
        this.priority = priority;
    }
}

