package game_world.factories;

import database.objects.AreaData;
import game_world.managers.EventManager;
import game_world.objects.Area;

public class AreaFactory {

    private final EventManager eventManager;

    public AreaFactory(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    /**
     * Generates new Area object and adds to the areas list
     * @return the new area generated
     * @param data data from existing AreaData
     */

    public Area createArea(AreaData data) {
        return new Area(
                data.id,
                data.name,
                data.speaker,
                data.zone,
                data.texts,
                data.next_ids,
                data.next_options,
                this.eventManager.getEventsFromArea(data.events)
        );
    }
}
