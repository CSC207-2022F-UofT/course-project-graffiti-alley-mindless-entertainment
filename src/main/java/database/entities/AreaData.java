package database.entities;

import java.util.ArrayList;

public class AreaData {

    /**
     * All information needed for an area
     */

    public final String id;
    public final String name;
    public final String speaker;
    public final String zone;
    public final ArrayList<String> texts;
    public final ArrayList<String> events;
    public final ArrayList<String> next_ids;
    public final ArrayList<String> next_options;

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

