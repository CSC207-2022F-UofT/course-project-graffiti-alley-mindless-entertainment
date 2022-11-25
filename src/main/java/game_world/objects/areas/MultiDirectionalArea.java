package game_world.objects.areas;

import game_world.objects.events.Event;
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
    }

    @Override
    public void preInput() {

    }

    @Override
    public void postInput(String input) {

    }

    @Override
    public boolean awaitInput() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public InputValidator getInputValidator() {
        return null;
    }
}
