package save;

import java.util.List;

/**
 * the class to load Saves
 */
public class SaveLoader {

    /**
     * @param s a Save to be saved into files
     * @param entities the list of Savable entities
     * update all Savable entities accordingly
     */
    public void loadSave(Save s, List<SavableEntity> entities) {
        for (SavableEntity e : entities) {
            e.fromSavableString(s.getFromId(e.getId()));
        }
    }
}

