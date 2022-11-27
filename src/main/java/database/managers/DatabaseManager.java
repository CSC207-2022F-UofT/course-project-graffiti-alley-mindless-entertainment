package database.managers;

import interfaces.IDatabase;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;



public abstract class DatabaseManager implements IDatabase {

    /**
     * Manages all matters regarding JSON database, JSON library is used nowhere else
     */

    public final String FILE_NAME = "src/main/resources/Database.json";
    public JSONObject fullDatabase;

    public DatabaseManager() {
        // Initialize Full Database
        initializeDatabase(FILE_NAME);
    }

    /**
     * @param fileName The JSON file name used
     */
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

    /**
     * Helper function to search JSON arrays
     * @param jsonArray initial jsonArray to iterate through
     * @return null if key-value pair does not exist in jsonArray, otherwise returns jsonObject of key-value pair
     */
    public JSONObject searchJSONArray(JSONArray jsonArray, String key, Object value) {
        for (Object obj: jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            if (jsonObject.get(key).equals(value)) {
                return jsonObject;
            }
        }
        return null;
    }
}
