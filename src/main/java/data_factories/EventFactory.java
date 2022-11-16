package data_factories;

import data_objects.EventData;
import org.json.simple.JSONObject;

public class EventFactory {

    public EventData createEventData(JSONObject jsonObject) {
        return new EventData(
                (String) jsonObject.get("name"),
                (String) jsonObject.get("type"),
                (String) jsonObject.get("area"),
                (int) jsonObject.get("priority")
        );
    }

}
