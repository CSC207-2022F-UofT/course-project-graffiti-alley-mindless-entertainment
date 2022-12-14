package database.factories;

import database.entities.ArbitraryEventData;
import database.entities.EncounterEventData;
import database.entities.ItemPickUpEventData;
import database.entities.QuestGiverEventData;
import org.json.simple.JSONObject;

public class EventDataFactory {

    /**
     * @param jsonObject JSONObject with all information regarding event
     * @return ArbitraryEventData with all instance attributes converted from jsonObject
     */
    public ArbitraryEventData createArbitraryEventData(JSONObject jsonObject) {
        return new ArbitraryEventData(
                (String) jsonObject.get("name"),
                (String) jsonObject.get("type")
        );
    }

    /**
     * @param jsonObject JSONObject with all information regarding event
     * @return EncounterEventData with all instance attributes converted from jsonObject
     */
    public EncounterEventData createEncounterEventData(JSONObject jsonObject) {
        return new EncounterEventData(
                (String) jsonObject.get("name"),
                (String) jsonObject.get("type"),
                (String) jsonObject.get("encounter-type"),
                (String) jsonObject.get("npc")
        );
    }

    /**
     * @param jsonObject JSONObject with all information regarding event
     * @return QuestGiverEventData with all instance attributes converted from jsonObject
     */
    public QuestGiverEventData createQuestGiverEventData(JSONObject jsonObject) {
        return new QuestGiverEventData(
                (String) jsonObject.get("name"),
                (String) jsonObject.get("type"),
                (String) jsonObject.get("quest"),
                (String) jsonObject.get("npc")
        );
    }

    /**
     * @param jsonObject JSONObject with all information regarding event
     * @return ItemPickUpEventData with all instance attributes converted from jsonObject
     */
    public ItemPickUpEventData createItemPickUpEventData(JSONObject jsonObject) {
        return new ItemPickUpEventData(
                (String) jsonObject.get("name"),
                (String) jsonObject.get("type"),
                (String) jsonObject.get("item"),
                (String) jsonObject.get("text")
        );
    }
}
