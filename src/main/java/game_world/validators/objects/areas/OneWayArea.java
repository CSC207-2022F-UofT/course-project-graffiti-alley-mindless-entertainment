package game_world.validators.objects.areas;

import game_world.validators.objects.events.Event;

import java.util.ArrayList;
import java.util.Collections;

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
        this.currTextIndex = 0;
    }

    @Override
    public ArrayList<String> getNextAreas() {
        return new ArrayList<>(Collections.singleton(this.next));
    }
}
