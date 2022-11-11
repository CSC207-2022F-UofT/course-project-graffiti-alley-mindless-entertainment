package managers;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

import objects.Database;

public class DatabaseManager {

    public Database fullDatabase;

    public DatabaseManager() {
        // Initialize Full Database
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/resources/Database.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            this.fullDatabase = new Database((JSONObject) obj);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    public Database getDatabase(String key) {
        if (this.fullDatabase.keyExists(key)) {
            JSONObject subTree = this.fullDatabase.getInfo(key);
            return new Database(subTree);
        }
        return null;
    }

    public Database getDatabase(Database database, String key) {
        if (database.keyExists(key)) {
            JSONObject subTree = database.getInfo(key);
            return new Database(subTree);
        }
        return null;
    }

    public String getData(String key) {
        if (this.fullDatabase.keyExists(key)) {
            JSONObject item = this.fullDatabase.getInfo(key);
            return item.toString();
        }
        return null;
    }

    public String getData(Database database, String key) {
        if (database.keyExists(key)) {
            JSONObject item = database.getInfo(key);
            return item.toString();
        }
        return null;
    }
}
