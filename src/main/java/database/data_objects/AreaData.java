package database.data_objects;

import java.util.ArrayList;
import java.util.Map;

public class AreaData {

    /**
     * All information needed for an arbitrary area
     */

    public String name;
    public String type;
    public String speaker;
    public ArrayList<String> texts;
    public String next;
    public Map<String, String> options;
    public ArrayList<String> events;

    public AreaData(String name, String type, String speaker, ArrayList<String> texts, String next, ArrayList<String> events) {
        this.name = name;
        this.type = type;
        this.speaker = speaker;
        this.texts = texts;
        this.next = next;
        this.events = events;
    }

    public AreaData(String name, String type, String speaker, ArrayList<String> texts, Map<String,String> options, ArrayList<String> events) {
        this.name = name;
        this.type = type;
        this.speaker = speaker;
        this.texts = texts;
        this.options = options;
        this.events = events;
    }
}

