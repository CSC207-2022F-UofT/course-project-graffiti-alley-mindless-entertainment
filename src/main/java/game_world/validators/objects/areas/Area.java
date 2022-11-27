package game_world.validators.objects.areas;

import game_world.validators.objects.events.Event;

import java.util.ArrayList;

public abstract class Area {

    /**
     * Main Area class with arbitrary instance attributes
     */

    String name;
    String type;
    String speaker;
    ArrayList<String> texts;

    int currTextIndex;
    ArrayList<Area> adjacentAreas;
    ArrayList<Event> events;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getSpeaker() {
        return speaker;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public ArrayList<String> getTexts() {
        return texts;
    }

    public int getCurrTextIndex() {
        return currTextIndex;
    }

    public ArrayList<Area> getAdjacentAreas() {
        return adjacentAreas;
    }

    public void incrementCurrTextIndex() {
        this.currTextIndex += 1;
    }

    public void addAdjacentArea(Area area) {
        this.adjacentAreas.add(area);
    }

    public String getAreaFromInput(String input) { return null; }
    public ArrayList<String> getNextAreas() { return null; }
    public ArrayList<String> getNextInputs() { return null; }
}
