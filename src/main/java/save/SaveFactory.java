package save;

import save.entities.SavableEntity;
import save.entities.Save;
import save.entities.SaveEntityId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * the class that used factory design pattern to create Saves
 */
public class SaveFactory {

    /**
     * @param entities the list of Savable entities
     * @return a Save created
     */
    public Save createSave(List<SavableEntity> entities) {
        Map<SaveEntityId, String> dataToSave = new HashMap<>();
        for (SavableEntity e : entities) {
            dataToSave.put(e.getId(), e.toSavableString());
        }
        return new Save(dataToSave);
    }
}
