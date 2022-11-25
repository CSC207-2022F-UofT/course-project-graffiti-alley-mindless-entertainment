package game_world.objects.areas;

import game_world.objects.events.Event;
import interfaces.State;

import java.util.ArrayList;

public abstract class Area implements State {

    /**
     * Main Area class with arbitrary instance attributes
     */

    public String name;
    public String type;
    public String speaker;
    public ArrayList<String> texts;
    public ArrayList<Area> adjacentAreas;
    public ArrayList<Event> events;
}
