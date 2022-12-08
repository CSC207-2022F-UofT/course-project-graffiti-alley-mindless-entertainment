package save;

import java.util.List;

public interface SaveGateway {

    /**
     * @param saves the saves to be saved
     * store the save in file
     */
    public void storeSaves(List<Save> saves);

    /**
     * @return the list of saves
     */
    public List<Save> retrieveSave();
}

