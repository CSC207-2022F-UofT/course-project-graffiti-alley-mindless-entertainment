package save;

import java.util.Map;

public class Save {
    Map<Id, SaveableEntity> savedData;

    public Save(Map<Id, SaveableEntity> dataToSave) {
        savedData = dataToSave;
    }

    /**
     * @param id id of an object to be saved
     * @return the corresponding string representation
     */
    public String getFromId(Id id) {
        return savedData.get(id).toString();
    }
}


