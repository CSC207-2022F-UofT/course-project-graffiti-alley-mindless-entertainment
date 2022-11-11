package objects;

import interfaces.IDatabase;
import org.json.simple.JSONObject;

public class Database implements IDatabase {

    private JSONObject database;

    public JSONObject getInfo(JSONObject database, String key) {return (JSONObject) database.get(key);}
    public JSONObject getInfo(String key) {return (JSONObject) this.database.get(key);}
    public boolean keyExists(String key) {return database.containsKey(key);}

    public Database(JSONObject database) {
        this.database = database;
    }
}
