package save;

import java.util.List;

public class SaveLoader {


    /**
     * @param s a save to be saved into files
     * @param entities the list of Saveable entities
     * update all Saveable entities accordingly
     */
    public void loadSave(Save s, List<SaveableEntity> entities) {
        for (SaveableEntity e : entities) {
            e.fromString(s.getFromId(e.getId()));
        }
    }
}

