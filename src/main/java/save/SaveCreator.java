package save;

import core.SaveableEntity;

import java.util.List;

public class SaveCreator {

    /**
     * @param entities the list of Saveable entities
     * @return a Save created
     */
    public Save createSave(List<SaveableEntity> entities) {
        Save s = new Save();
        return s;
    }
}

