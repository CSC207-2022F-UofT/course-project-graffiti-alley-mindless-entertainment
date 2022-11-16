package managers;

import interfaces.IDatabase;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

import data_factories.EventFactory;

import data_objects.EventData;


public class DatabaseManager implements IDatabase {


    public JSONObject fullDatabase;
    public EventFactory eventFactory;

    /**
     * Helper function to search JSON arrays
     */
    private JSONObject searchJSONArray(JSONArray jsonArray, String key, Object value) {
        for (Object obj: jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            if (jsonObject.get(key) == value) {
                return jsonObject;
            }
        }
        return null;
    }

    public DatabaseManager() {
        // Initialize Full Database
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/resources/Database.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            this.fullDatabase = (JSONObject) obj;
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        // Initialize Factories
        this.eventFactory = new EventFactory();
    }

    /**
     * @return EventData with all data from json converted to variables
     */
    public EventData fetchEvent(String key, Object value) {
        JSONArray eventsData = (JSONArray) this.fullDatabase.get("events");
        JSONObject eventData = searchJSONArray(eventsData, key, value);
        assert eventData != null;
        return eventFactory.createEventData(eventData);
    }

}
