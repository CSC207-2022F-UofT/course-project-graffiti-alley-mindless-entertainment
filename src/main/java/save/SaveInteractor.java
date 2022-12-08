package save;

import io.Output;

import java.util.ArrayList;

/**
 * the interactor class to manage loading Saves and saving Saves
 */
public class SaveInteractor {

    /**
     * entities: the list pf savable entities
     * saves: the list of Saves
     * loader: the loader to help load Saves
     * creator: the creator to help create Saves
     * MAX_SLOTS: the maximum space for Saves
     */
    ArrayList<SavableEntity> entities;
    ArrayList<Save> saves;
    SaveLoader loader;
    SaveFactory creator;
    private int MAX_SLOTS;

    public SaveInteractor(int max_slots) {
        entities = new ArrayList<>();
        saves = new ArrayList<>(MAX_SLOTS + 1);
        for (int i = 0; i < max_slots + 1; i++) {
            saves.add(null);
        }
        loader = new SaveLoader();
        creator = new SaveFactory();
        MAX_SLOTS = max_slots;
    }

    public int getMaxSlots() {
        return MAX_SLOTS;
    }

    /**
     * @param slot the slot to load file from
     * @return whether loaded successfully or not
     */
    public boolean loadFromSlot(int slot) {
        if (slot > MAX_SLOTS) {
            return false;
        }
        Save s = saves.get(slot);
        if (s == null) {
            return false;
        }
        loader.loadSave(s, entities);
        return true;
    }

    /**
     * @param slot the slot to save file at
     */
    public void saveAtSlot(int slot) {
        Save s = creator.createSave(entities);
        saves.set(slot, s);
    }

    /**
     * displays all slots status
     */
    public void displaySlots() {
        StringBuilder msg = new StringBuilder("Saves: \n");
        for (int i = 1; i <= MAX_SLOTS; ++ i) {
            msg.append("Slot #");
            msg.append(i);
            if (saves.get(i) == null) {
                msg.append(": vacant");
            } else {
                msg.append(": occupied");
            }
            msg.append("\n");
        }
        Output.getScreen().generateText(msg.toString());
    }

    /**
     * @param e the savable entity to be added
     * add the savable entity to the list of entities
     */
    public void addSavableEntity(SavableEntity e) {
        entities.add(e);
    }
}
