package save;

import java.util.List;

public interface SaveGateway {

    /**
     * @param saves the saves to be saved
     * saves saves into file
     */
    public void storeSaves(List<Save> saves);

    /**
     * @return the save
     */
    public List<Save> retrieveSave();
}

