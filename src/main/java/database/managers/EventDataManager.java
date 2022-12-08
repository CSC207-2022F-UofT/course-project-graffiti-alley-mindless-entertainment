package database.managers;

import database.DatabaseHelper;
import database.factories.EventDataFactory;
import database.objects.ArbitraryEventData;
import database.objects.EncounterEventData;
import database.objects.ItemPickUpEventData;
import database.objects.QuestGiverEventData;
import game_world.objects.events.EventType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class EventDataManager extends DatabaseManager {

    private final EventDataFactory dataFactory;
    private final DatabaseHelper databaseHelper;

    /**
     * @param name of event
     * @return type of event
     */
    public EventType fetchEventType(String name) {
        JSONArray eventsData = (JSONArray) super.fullDatabase.get("events");
        JSONObject eventData = databaseHelper.searchJSONArray(eventsData, "name", name);
        return switch ((String) eventData.get("type")) {
            case "Encounter" -> EventType.ENCOUNTER;
            case "Item Pick-Up" -> EventType.ITEM_PICKUP;
            case "Quest Giver" -> EventType.QUEST_GIVER;
            default -> EventType.ARBITRARY;
        };
    }

    /**
     * @param key of an arbitrary event
     * @param value of the arbitrary event
     * @return ArbitraryEventData with all json objects converted to String/long variables
     */
    public ArbitraryEventData fetchArbitraryEvent(String key, Object value) {
        JSONArray eventsData = (JSONArray) super.fullDatabase.get("events");
        JSONObject eventData = databaseHelper.searchJSONArray(eventsData, key, value);
        assert eventData != null;
        assert (eventData.get("type")).equals("Arbitrary");
        return this.dataFactory.createArbitraryEventData(eventData);
    }

    /**
     * @param key of an arbitrary event
     * @param value of the arbitrary event
     * @return EncounterEventData with all json objects converted to String/long variables
     */
    public EncounterEventData fetchEncounterEvent(String key, Object value) {
        JSONArray eventsData = (JSONArray) super.fullDatabase.get("events");
        JSONObject eventData = databaseHelper.searchJSONArray(eventsData, key, value);
        assert eventData != null;
        assert (eventData.get("type")).equals("Encounter");
        return this.dataFactory.createEncounterEventData(eventData);
    }

    /**
     * @param key of an arbitrary event
     * @param value of the arbitrary event
     * @return QuestGiverEventData with all json objects converted to String/long variables
     */
    public QuestGiverEventData fetchQuestGiverEvent(String key, Object value) {
        JSONArray eventsData = (JSONArray) super.fullDatabase.get("events");
        JSONObject eventData = databaseHelper.searchJSONArray(eventsData, key, value);
        assert eventData != null;
        assert (eventData.get("type")).equals("Quest Giver");
        return this.dataFactory.createQuestGiverEventData(eventData);
    }

    /**
     * @param key of an arbitrary event
     * @param value of the arbitrary event
     * @return ItemPickUpEventData with all json objects converted to String/long variables
     */
    public ItemPickUpEventData fetchItemPickUpEvent(String key, Object value) {
        JSONArray eventsData = (JSONArray) super.fullDatabase.get("events");
        JSONObject eventData = databaseHelper.searchJSONArray(eventsData, key, value);
        assert eventData != null;
        assert (eventData.get("type")).equals("Item Pick-Up");
        return this.dataFactory.createItemPickUpEventData(eventData);
    }

    public EventDataManager() {
        // change file below to required json file
        String FILE_NAME = "src/main/resources/EventDatabase.json";
        super.initializeDatabase(FILE_NAME);
        this.databaseHelper = new DatabaseHelper();
        this.dataFactory = new EventDataFactory();
    }
}
