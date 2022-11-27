package game_world.validators.objects.areas;

import game_world.validators.objects.events.Event;

import java.util.ArrayList;
import java.util.Map;

public class MultiDirectionalArea extends Area {

    /**
     * Area that leads to multiple areas
     */

    public Map<String, String> options;

    public MultiDirectionalArea(String name, String speaker, ArrayList<String> texts,
                                Map<String, String> options, ArrayList<Event> events) {
        this.name = name;
        this.type = "Multi-Directional";
        this.speaker = speaker;
        this.texts = texts;
        this.options = options;
        this.events = events;
        this.currTextIndex = 0;
    }

    public ArrayList<String> getNextInputs() {
        return new ArrayList<>(this.options.keySet());
    }

    public ArrayList<String> getNextAreas() {
        return new ArrayList<>(this.options.values());
    }

    public String getAreaFromInput(String input) {
        return options.get(input);
    }
}
