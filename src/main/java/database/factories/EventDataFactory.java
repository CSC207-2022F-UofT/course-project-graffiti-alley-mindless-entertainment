package database.factories;

import database.objects.EventData;
import org.json.simple.JSONObject;

public class EventDataFactory {

    /**
     * @param jsonObject JSONObject with all information regarding event
     * @return EventData with all instance attributes converted from jsonObject
     */
    public EventData createEventData(JSONObject jsonObject) {
        return new EventData(
                (String) jsonObject.get("name"),
                (String) jsonObject.get("type"),
                (long) jsonObject.get("priority")
        );
    }

}
