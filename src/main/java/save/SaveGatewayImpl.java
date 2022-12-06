package save;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SaveGatewayImpl implements SaveGateway{

    private final SaveConverterHelper helper;

    public SaveGatewayImpl() {
        helper = new SaveConverterHelper();
    }

    /**
     * @param saves the saves to be saved
     * save the saves into file
     */
    @Override
    public void storeSaves(List<Save> saves) {
        String toWrite = helper.saveToJson(saves);
        String FILE_NAME = "src/main/resources/save/SavedData.json";
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            writer.write(toWrite);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @return the list of saves
     */
    @Override
    public List<Save> retrieveSave() {
        String FILE_NAME = "src/main/resources/save/SavedData.json";
        JSONArray jsonArray = this.initializeData(FILE_NAME);
        return helper.jsonToSave(jsonArray.toJSONString());
    }

    /**
     * @param fileName the file name to write into
     * @return an initialized json file
     */
    public JSONArray initializeData(String fileName) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(fileName))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            return (JSONArray) obj;
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
