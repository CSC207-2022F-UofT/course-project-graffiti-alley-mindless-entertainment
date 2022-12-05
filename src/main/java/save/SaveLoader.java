package save;

import java.util.List;

public class SaveLoader {


    /**
     * @param s a save to be saved into files
     * @param entities the list of Savable entities
     * update all Savable entities accordingly
     */
    public void loadSave(Save s, List<SavableEntity> entities) {
        for (SavableEntity e : entities) {
            e.fromSavableString(s.getFromId(e.getId()));
        }
    }
}

