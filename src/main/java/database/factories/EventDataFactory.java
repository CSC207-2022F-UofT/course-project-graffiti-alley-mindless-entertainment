package database.factories;

import database.objects.EventData;
import org.json.simple.JSONObject;

public class EventDataFactory {

    /**
     * @param jsonObject JSONObject with all information regarding event
     * @return EventData with all instance attributes converted from jsonObject
     */
    public EventData createEventData(JSONObject jsonObject) {
        String type = (String) jsonObject.get("type");
        if (type.equals("Encounter")) {
            return new EventData(
                    (String) jsonObject.get("name"),
                    type,
                    (String) jsonObject.get("encounter-type"),
                    (String) jsonObject.get("npc")
            );
        }
        else if (type.equals("Item Pick-Up")) {
            return new EventData(
                    (String) jsonObject.get("name"),
                    type,
                    (String) jsonObject.get("item")
            );
        }
        else {
            return new EventData(
                    (String) jsonObject.get("name"),
                    type
            );
        }
    }

}
