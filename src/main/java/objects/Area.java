package objects;

import java.util.ArrayList;
import java.util.Map;

public abstract class Area {

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
