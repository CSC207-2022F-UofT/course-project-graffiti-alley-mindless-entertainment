package database.managers;

import interfaces.IDatabase;
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

}
