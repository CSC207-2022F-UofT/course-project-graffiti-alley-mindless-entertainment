package save;

import java.util.Map;

public class Save {
    Map<SaveEntityId, String> savedData;

    public Save(Map<SaveEntityId, String> dataToSave) {
        savedData = dataToSave;
    }

    /**
     * @param id id of an object to be saved
     * @return the corresponding string representation
     */
    public String getFromId(SaveEntityId id) {
        return savedData.get(id);
    }
}


