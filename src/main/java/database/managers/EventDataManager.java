package database.managers;

import database.factories.EventDataFactory;
import database.objects.EventData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class EventDataManager extends DatabaseManager {

    public EventDataFactory dataFactory;

    /**
     * Helper function to search JSON arrays
     * @param jsonArray initial jsonArray to iterate through
     * @return null if key-value pair does not exist in jsonArray, otherwise returns jsonObject of key-value pair
     */
    private JSONObject searchJSONArray(JSONArray jsonArray, String key, Object value) {
        for (Object obj: jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            if (jsonObject.get(key).equals(value)) {
                return jsonObject;
            }
        }
        return null;
    }

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