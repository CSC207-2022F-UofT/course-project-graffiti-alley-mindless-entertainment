package save;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaveFactory {

    /**
     * @param entities the list of Saveable entities
     * @return a Save created
     */
    public Save createSave(List<SaveableEntity> entities) {
        Map<SaveEntityId, String> dataToSave = new HashMap<SaveEntityId, String>();
        for (SaveableEntity e : entities) {
            dataToSave.put(e.getId(), e.toString());
        }
        return new Save(dataToSave);
    }
}
