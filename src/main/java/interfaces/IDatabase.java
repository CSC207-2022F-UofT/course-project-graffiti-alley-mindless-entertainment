package interfaces;

import org.json.simple.JSONObject;

public interface IDatabase {

    JSONObject database = new JSONObject();
    default JSONObject getInfo(JSONObject database, String key) {return (JSONObject) database.get(key);}
    default boolean keyExists(String key) {return database.containsKey(key);}
}
