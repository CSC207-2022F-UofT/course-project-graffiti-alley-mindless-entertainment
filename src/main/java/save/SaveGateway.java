package save;

import java.util.List;

public interface SaveGateway {

    /**
     * @param s the save to be saved
     * saves s into file
     */
    public void storeSaves(List<Save> s);

    /**
     * @return the save
     */
    public List<Save> retrieveSave();
}
