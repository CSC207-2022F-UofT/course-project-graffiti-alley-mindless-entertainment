package save;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaveFactory {

    /**
     * @param entities the list of Saveable entities
     * @return a Save created
     */
    public Save createSave(List<SaveableEntity> entities) {
        Map<Id, SaveableEntity> dataToSave = new HashMap<Id, SaveableEntity>();
        int size = entities.size();
        int i = 0;
        for (Id id : Id.values()) {
            dataToSave.put(id, entities.get(i ++));
            if (i == size) {
                break;
            }
        }
        return new Save(dataToSave);
    }
}
