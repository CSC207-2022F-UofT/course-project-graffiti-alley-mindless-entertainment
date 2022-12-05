package save;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaveFactory {

    /**
     * @param entities the list of Savable entities
     * @return a Save created
     */
    public Save createSave(List<SavableEntity> entities) {
        Map<SaveEntityId, String> dataToSave = new HashMap<SaveEntityId, String>();
        for (SavableEntity e : entities) {
            dataToSave.put(e.getId(), e.toSavableString());
        }
        return new Save(dataToSave);
    }
}
