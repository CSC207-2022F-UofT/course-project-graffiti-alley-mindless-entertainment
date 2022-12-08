package save;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.*;

/**
 * implementation of SaveGateway
 */
public class SaveGatewayImpl implements SaveGateway{

    /**
     * helper: the helper to help convert between Saves and json files
     */
    private final SaveConverterHelper helper;

    public SaveGatewayImpl() {
        helper = new SaveConverterHelper();
    }

    /**
     * @param saves the Saves to be saved
     * save the Saves into file
     */
    @Override
    public void storeSaves(List<Save> saves) {
        String toWrite = helper.saveToJson(saves);
        String FILE_NAME = "src/main/resources/saves/SavedData.json";
        File f = new File(FILE_NAME);
        if(!f.exists()) {
            try {
                boolean isSuccess = f.createNewFile();
                if (!isSuccess) {
                    throw new RuntimeException();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
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
        String FILE_NAME = "src/main/resources/saves/SavedData.json";
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
        } catch (FileNotFoundException e) {
            return new JSONArray();
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
