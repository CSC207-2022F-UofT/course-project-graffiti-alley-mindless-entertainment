package game_world.factories;

import database.objects.ArbitraryEventData;
import database.objects.EncounterEventData;
import database.objects.ItemPickUpEventData;
import game_world.objects.events.ArbitraryEvent;
import game_world.objects.events.EncounterEvent;
import game_world.objects.events.ItemPickUpEvent;

public class EventFactory {

    /**
     * @return the new arbitrary event
     * @param data data from current ArbitraryEventData
     */
    public ArbitraryEvent createArbitraryEvent(ArbitraryEventData data) {
        return new ArbitraryEvent(
                data.name
        );
    }

    /**
     * @return the new encounter event
     * @param data data from current EncounterEventData
     */
    public EncounterEvent createEncounterEvent(EncounterEventData data) {
        return new EncounterEvent(
                data.name,
                data.encounterType,
                data.npc,
                data.questName
        );
    }

    /**
     * @return the new item pickup event
     * @param data data from current ItemPickUpEventData
     */
    public ItemPickUpEvent createItemPickUpEvent(ItemPickUpEventData data) {
        return new ItemPickUpEvent(
                data.name,
                data.item,
                data.text
        );
    }
}
