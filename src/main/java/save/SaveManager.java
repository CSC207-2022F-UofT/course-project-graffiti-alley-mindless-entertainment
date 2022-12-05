package save;

import java.util.ArrayList;


public class SaveManager {
    ArrayList<SaveableEntity> entities;
    ArrayList<Save> saves;
    SaveLoader loader;
    SaveFactory creator;
    private int MAX_SLOTS;

    public SaveManager() {
        loader = new SaveLoader();
        creator = new SaveFactory();
    }

    public int getMaxSlots() {
        return MAX_SLOTS;
    }

    /**
     * @param slot the slot to load file from
     * @return whether loaded successfully or not
     */
    public boolean loadFromSlot(int slot) {
        Save s = saves.get(slot);
        if (s == null) {
            return false;
        }
        loader.loadSave(s, entities);
        return true;
    }

    /**
     * @param slot the slot to save file at
     * @return whether saved successfully or not
     */
    public boolean saveAtSlot(int slot) {
        if (slot > MAX_SLOTS) {
            return false;
        }
        if (saves.get(slot) == null) {
            Save s = creator.createSave(entities);
            saves.set(slot, s);
            return true;
        }
        return false;
    }
}
