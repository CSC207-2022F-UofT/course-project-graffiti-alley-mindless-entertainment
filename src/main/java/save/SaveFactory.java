package save;

import core.SaveableEntity;

import java.util.ArrayList;


public abstract class SaveFactory {
    ArrayList<SaveableEntity> entities;
    ArrayList<Save> saves;
    SaveLoader loader = new SaveLoader();
    SaveCreator creator = new SaveCreator();

    public void loadFromSlot(int slot) {
        loader.loadSave(saves.get(slot), entities);
    }

    public void saveAtSlot() {
        saves.add(creator.createSave(entities));
    }
}

