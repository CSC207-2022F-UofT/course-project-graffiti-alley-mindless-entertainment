package objects;

import org.json.simple.JSONObject;

public class Database {

    private JSONObject database;

    public JSONObject getInfo(JSONObject database, String key) {return (JSONObject) database.get(key);}
    public JSONObject getInfo(String key) {return (JSONObject) this.database.get(key);}
    public boolean keyExists(String key) {return database.containsKey(key);}

    public Database(JSONObject database) {
        this.database = database;
    }
}
