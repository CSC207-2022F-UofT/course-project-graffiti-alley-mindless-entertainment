package save.entities;

import java.util.Map;

/**
 * the class to manage savable entities
 */
public class Save {

    /**
     * savedData: the data saved
     */
    Map<SaveEntityId, String> savedData;

    public Save(Map<SaveEntityId, String> dataToSave) {
        savedData = dataToSave;
    }

    public Map<SaveEntityId, String> getSavedData() {
        return savedData;
    }

    /**
     * @param id id of an object to be saved
     * @return the corresponding string representation
     */
    public String getFromId(SaveEntityId id) {
        return savedData.get(id);
    }
}


