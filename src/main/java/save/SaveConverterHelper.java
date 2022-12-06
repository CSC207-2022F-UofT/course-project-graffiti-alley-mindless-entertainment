package save;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.util.*;

public class SaveConverterHelper {

    /**
     * @param saves the saves to be saved into file
     * @return the converted string to be saved into file
     */
    @SuppressWarnings("unchecked")
    public String saveToJson(List<Save> saves) {
        JSONArray jsonArray = new JSONArray();
        for (Save save : saves) {
            JSONObject jsonObject = new JSONObject();
            Map<SaveEntityId, String> s = save.getSavedData();
            Set<SaveEntityId> keys = s.keySet();
            for (SaveEntityId key : keys) {
                jsonObject.put(key.toString(), s.get(key));
            }
            jsonArray.add(jsonObject);
        }
        return jsonArray.toJSONString();
    }

    /**
     * @param str the string of saved saves
     * @return the converted saves
     */
    @SuppressWarnings("unchecked")
    public List<Save> jsonToSave(String str) {
        JSONParser jsonParser = new JSONParser();
        try
        {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(str);
            List<Save> saves = new ArrayList<Save>();
            for (Object o : jsonArray) {
                JSONObject jsonObject = (JSONObject) o;
                Set<String> keys = jsonObject.keySet();
                Map<SaveEntityId, String> s = new HashMap<SaveEntityId, String>();
                for (String key : keys) {
                    s.put(SaveEntityId.valueOf(key), (String) jsonObject.get(key));
                }
                Save save = new Save(s);
                saves.add(save);
            }
            return saves;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
