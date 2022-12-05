package save;

import java.util.Map;

public class Save {
    Map<String, String> savedData;

    /**
     * @param id id of an object to be saved
     * @return the corresponding string representation
     */
    public String getFromId(String id) {
        return savedData.get(id);
    }
}

