package save;

import java.util.ArrayList;


public class SaveManager {
    ArrayList<SaveableEntity> entities;
    ArrayList<Save> saves;
    SaveLoader loader = new SaveLoader();
    SaveFactory creator = new SaveFactory();

    public void loadFromSlot(int slot) {
        loader.loadSave(saves.get(slot), entities);
    }

    public void saveAtSlot() {
        saves.add(creator.createSave(entities));
    }
}

