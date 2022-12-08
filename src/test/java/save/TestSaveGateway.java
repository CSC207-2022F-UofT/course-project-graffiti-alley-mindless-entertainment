package save;

import java.util.ArrayList;
import java.util.List;

public class TestSaveGateway implements SaveGateway{
    /**
     * @param saves the saves to be saved
     *              store the save in file
     */
    @Override
    public void storeSaves(List<Save> saves) {
    }

    /**
     * @return the list of saves
     */
    @Override
    public List<Save> retrieveSave() {
        return new ArrayList<>();
    }
}
