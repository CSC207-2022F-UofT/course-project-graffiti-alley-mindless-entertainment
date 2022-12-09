package save.use_cases;

import save.SaveFactory;
import save.gateways.SaveGateway;
import save.entities.SavableEntity;
import save.entities.Save;

import java.util.ArrayList;
import java.util.List;

/**
 * the interactor class to manage loading Saves and saving Saves
 */
public class SaveInteractor {

    /**
     * entities: the list pf savable entities
     * saves: the list of Saves
     * loader: the loader to help load Saves
     * creator: the creator to help create Saves
     * gateway: the gateway to save file
     * MAX_SLOTS: the maximum space for Saves
     */
    List<SavableEntity> entities;
    List<Save> saves;
    SaveLoader loader;
    SaveFactory creator;
    SaveGateway gateway;
    private final int MAX_SLOTS;

    public SaveInteractor(int max_slots, SaveGateway gateway) {
        entities = new ArrayList<>();
        saves = gateway.retrieveSave();
        int save_size = saves.size();
        for (int i = 0; i < max_slots - save_size + 1; i++) {
            saves.add(null);
        }
        loader = new SaveLoader();
        creator = new SaveFactory();
        this.gateway = gateway;
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
        gateway.storeSaves(saves);
    }

    /**
     * @return all slots status
     */
    public String getSlotsStatus() {
        StringBuilder msg = new StringBuilder("Saves: \n");
        msg.append("Slot #0: autosave\n");
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
        return msg.toString();
    }

    /**
     * @param e the savable entity to be added
     * add the savable entity to the list of entities
     */
    public void addSavableEntity(SavableEntity e) {
        entities.add(e);
    }
}
