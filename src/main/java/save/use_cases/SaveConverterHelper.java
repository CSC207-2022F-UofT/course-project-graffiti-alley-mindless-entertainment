package save.use_cases;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import save.entities.Save;
import save.entities.SaveEntityId;

import java.util.*;

/**
 * the helper class to help convert between saves and json files
 */
public class SaveConverterHelper {

    /**
     * @param saves the saves to be saved into file
     * @return the converted string to be saved into file
     * warning suppressed because json library implements key set as generic,
     * but in this implementation it is made sure to be a string.
     */
    @SuppressWarnings("unchecked")
    public String saveToJson(List<Save> saves) {
        JSONArray jsonArray = new JSONArray();
        for (Save save : saves) {
            JSONObject jsonObject = new JSONObject();
            if (save == null) {
                jsonArray.add(jsonObject);
                continue;
            }
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
     * warning suppressed because json library implements key set as generic,
     * but in this implementation it is made sure to be a string.
     */
    @SuppressWarnings("unchecked")
    public List<Save> jsonToSave(String str) {
        JSONParser jsonParser = new JSONParser();
        try
        {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(str);
            List<Save> saves = new ArrayList<>();
            for (Object o : jsonArray) {
                JSONObject jsonObject = (JSONObject) o;
                Set<String> keys = jsonObject.keySet();
                Map<SaveEntityId, String> s = new HashMap<>();
                if (keys.size() == 0) {
                    saves.add(null);
                    continue;
                }
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
