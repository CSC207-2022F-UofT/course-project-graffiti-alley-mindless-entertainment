package objects;

import java.util.ArrayList;

public class OneWayArea extends Area {

    /**
     * Area that leads to a single area
     */

    public String next;

    public OneWayArea(String name, String speaker, ArrayList<String> texts, String next, ArrayList<Event> events) {
        this.name = name;
        this.type = "One-Way";
        this.speaker = speaker;
        this.texts = texts;
        this.next = next;
        this.events = events;
    }
}
