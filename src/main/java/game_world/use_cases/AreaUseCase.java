package game_world.use_cases;

import game_world.entities.Area;
import game_world.entities.Location;
import io.Output;
import io.OutputHandler;

import java.util.ArrayList;

public class AreaUseCase {

    /**
     * Directly manages currentArea of the game
     * Used as use case interactor by AreaManager
     */

    private final AreaDatabaseInteractor databaseController;
    private final Location location;

    public AreaUseCase(AreaDatabaseInteractor databaseController, Location location) {
        this.location = location;
        this.databaseController = databaseController;
    }

    /**
     * @return currentArea of Player
     */
    public Area getCurrentArea() {
        return location.getCurrentArea();
    }

    /**
     * Changes current area to next loaded area from id
     * @param id of Area to be loaded and changed to
     */
    public void getToNextArea(String id) {
        // save events and data here
        Area nextArea = databaseController.loadArea(id);
        this.location.setCurrentArea(nextArea);
    }

    /**
     * Get to next Area from input and send arrival message
     * @param input input of the user
     */
    public void arriveAtNextArea(String input) {
        OutputHandler output = Output.getScreen();
        getToNextArea(location.getCurrentArea().getAreaFromInput(input.toLowerCase()));
        if (location.getCurrentArea().getName().equals("GAME"))
            output.generateText("You approach " + location.getCurrentArea().getName() + " in " + location.getCurrentArea().getZone() + ".\n");
    }

    /**
     * Updates event index of the area
     */
    public void updateEventIndex() {
        location.getCurrentArea().setCurrEventIndex(location.getCurrentArea().getCurrTextIndex() + 1);
    }

    /**
     * @return Allowed inputs from current area
     */
    public ArrayList<String> getNextInputs() {
        return location.getCurrentArea().getNextInputs();
    }

    /**
     * @return true if the current input is valid
     */
    public boolean checkForValidInput(String input) {
        if (location.getCurrentArea().getNextInputs().size() == 1)
            return true;
        return location.getCurrentArea().getNextInputs().contains(input.toLowerCase());
    }

    /**
     * @return true if the user has just arrived at an area
     */
    public boolean checkForAreaEntered() {
        return location.getCurrentArea().getCurrTextIndex() == 0;
    }
}
