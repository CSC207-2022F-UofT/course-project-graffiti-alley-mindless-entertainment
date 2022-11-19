package database.data_objects;

public class EventData {

    public String name;
    public String type;
    public String area;
    public int priority;

    public EventData(String name, String type, String area, int priority) {
        this.name = name;
        this.type = type;
        this.area = area;
        this.priority = priority;
    }
}

