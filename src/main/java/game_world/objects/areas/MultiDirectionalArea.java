package game_world.objects.areas;

import game_world.objects.Action;
import game_world.objects.events.Event;
import game_world.validators.AreaInputValidator;
import io.InputValidator;

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

    public String getNextArea(String choice) {
        return this.options.get(choice);
    }
}
