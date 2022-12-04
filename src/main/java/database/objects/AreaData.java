package database.objects;

import java.util.ArrayList;
import java.util.Map;

public class AreaData {

    /**
     * All information needed for an area
     */

    public String id;
    public String name;
    public String speaker;
    public String zone;
    public ArrayList<String> texts;
    public ArrayList<String> events;
    public ArrayList<String> next_ids;
    public ArrayList<String> next_options;

    public AreaData(String id, String name, String speaker, String zone, ArrayList<String> texts,
                    ArrayList<String> next_ids, ArrayList<String> next_options, ArrayList<String> events) {
        this.id = id;
        this.name = name;
        this.speaker = speaker;
        this.zone = zone;
        this.texts = texts;
        this.next_ids = next_ids;
        this.next_options = next_options;
        this.events = events;
    }
}

