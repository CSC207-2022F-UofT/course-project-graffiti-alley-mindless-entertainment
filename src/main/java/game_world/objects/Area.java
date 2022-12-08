package game_world.objects;

import game_world.objects.events.Event;

import java.util.ArrayList;

public class Area {

    /**
     * Main Area class with arbitrary instance attributes
     */

    private final String id;
    private final String name;
    private final String speaker;
    private final String zone;
    private final ArrayList<String> texts;
    private final ArrayList<String> next_ids;
    private final ArrayList<String> next_options;
    private final ArrayList<Event> events;
    private int currTextIndex;
    private int currEventIndex;

    public Area(String id, String name, String speaker, String zone, ArrayList<String> texts,
                ArrayList<String> next_ids, ArrayList<String> next_options, ArrayList<Event> events) {
        this.id = id;
        this.name = name;
        this.speaker = speaker;
        this.zone = zone;
        this.texts = texts;
        this.next_ids = next_ids;
        this.next_options = next_options;
        this.events = events;
        this.currTextIndex = 0;
        this.currEventIndex = 0;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getSpeaker() { return speaker; }
    public String getZone() { return zone; }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public ArrayList<String> getTexts() {
        return texts;
    }

    public int getCurrTextIndex() {
        return currTextIndex;
    }

    public void setCurrTextIndex(int newValue) {
        this.currTextIndex = newValue;
    }

    public Event getCurrEvent() {
        if (this.events.size() <= this.currEventIndex) return null;
        return this.events.get(this.currEventIndex);
    }

    public void setCurrEventIndex(int newValue) {
        this.currEventIndex = newValue;
    }

    public String getType() {
        if (this.next_ids.size() == 1) {
            return "One-Way";
        }
        else {
            return "Multi-Directional";
        }
    }

    public ArrayList<String> getNextInputs() {
        return this.next_options;
    }

    public String getAreaFromInput(String input) {
        for (int i = 0; i < this.next_options.size(); i++) {
            if (this.next_options.get(i).equals(input)) {
                return this.next_ids.get(i);
            }
        }
        return null;
    }
}
