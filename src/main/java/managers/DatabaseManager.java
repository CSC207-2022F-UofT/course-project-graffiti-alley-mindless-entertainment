package managers;

import interfaces.IDatabase;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

import data_factories.EventDataFactory;


public class DatabaseManager implements IDatabase {

    public final String fileName = "src/main/resources/Database.json";
    public JSONObject fullDatabase;
    public EventDataFactory eventFactory;

    public DatabaseManager() {
        // Initialize Full Database
        initializeDatabase(fileName);

        // Initialize Factories
        this.eventFactory = new EventDataFactory();
    }

    public void initializeDatabase(String fileName) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(fileName))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            this.fullDatabase = (JSONObject) obj;
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}
