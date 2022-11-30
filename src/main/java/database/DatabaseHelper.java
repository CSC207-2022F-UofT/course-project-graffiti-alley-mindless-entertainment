package database;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DatabaseHelper {

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
