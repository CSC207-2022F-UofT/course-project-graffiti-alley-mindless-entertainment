package game_world.factories;

import database.objects.AreaData;
import game_world.managers.EventDatabaseInteractor;
import game_world.objects.Area;

public class AreaFactory {

    /**
     * A factory class for creating new Areas. Used to avoid dependencies in AreaManager.
     */

    private final EventDatabaseInteractor eventDatabaseInteractor;

    public AreaFactory(EventDatabaseInteractor eventDatabaseInteractor) {
        this.eventDatabaseInteractor = eventDatabaseInteractor;
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
                this.eventDatabaseInteractor.getEventsFromArea(data.events)
        );
    }
}
