package game_world.objects.events;

public class EncounterEvent extends Event {

    /**
     * Event executes when there is an encounter between entities (to be implemented)
     */

    public EncounterEvent(String name, long priority) {
        this.name = name;
        this.type = "Encounter";
        this.priority = priority;
        this.eventState = 0;
    }

    @Override
    public void execute() {

    }
}