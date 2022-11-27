package database.managers;

import database.factories.EventDataFactory;
import database.objects.EventData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class EventDataManager extends DatabaseManager {

    public EventDataFactory dataFactory;

    /**
     * @return EventData with all data from json converted to variables
     */
    public EventData fetchEvent(String key, Object value) {
        JSONArray eventsData = (JSONArray) super.fullDatabase.get("events");
        JSONObject eventData = searchJSONArray(eventsData, key, value);
        assert eventData != null;
        return this.dataFactory.createEventData(eventData);
    }

    public EventDataManager() {
        this.dataFactory = new EventDataFactory();
    }
}
