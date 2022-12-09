package save.gateways;

import save.entities.Save;

import java.util.List;

public interface SaveGateway {

    /**
     * @param saves the saves to be saved
     * store the save in file
     */
    void storeSaves(List<Save> saves);

    /**
     * @return the list of saves
     */
    List<Save> retrieveSave();
}

