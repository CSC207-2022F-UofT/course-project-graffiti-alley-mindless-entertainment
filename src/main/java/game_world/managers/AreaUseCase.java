package game_world.managers;

import game_world.objects.Area;
import game_world.objects.Location;
import io.Output;
import io.OutputHandler;

import java.util.ArrayList;

public class AreaUseCase {

    /**
     * Directly manages currentArea of the game
     * Used as use case interactor by AreaManager
     */

    private final AreaDatabaseInteractor databaseController;
    private Area currentArea;
    private final Location location;

    public AreaUseCase(AreaDatabaseInteractor databaseController, Location location) {
        this.location = location;
        this.databaseController = databaseController;
    }

    /**
     * @return currentArea of Player
     */
    public Area getCurrentArea() {
        return this.currentArea;
    }

    /**
     * Changes current area to next loaded area from id
     * @param id of Area to be loaded and changed to
     */
    public void getToNextArea(String id) {
        // save events and data here
        this.currentArea = databaseController.loadArea(id);
        this.location.setCurrentArea(this.currentArea);
    }

    /**
     * Get to next Area from input and send arrival message
     * @param input input of the user
     */
    public void arriveAtNextArea(String input) {
        OutputHandler output = Output.getScreen();
        getToNextArea(this.currentArea.getAreaFromInput(input.toLowerCase()));
        output.generateText("You approach " + this.currentArea.getName() + " in " + this.currentArea.getZone() + ".");
    }

    /**
     * Updates event index of the area
     */
    public void updateEventIndex() {
        this.currentArea.setCurrEventIndex(this.currentArea.getCurrTextIndex() + 1);
    }

    /**
     * @return Allowed inputs from current area
     */
    public ArrayList<String> getNextInputs() {
        return this.currentArea.getNextInputs();
    }

    /**
     * @return true if the current input is valid
     */
    public boolean checkForValidInput(String input) {
        return this.currentArea.getNextInputs().contains(input.toLowerCase());
    }

    /**
     * @return true if the user has just arrived at an area
     */
    public boolean checkForAreaEntered() {
        return this.currentArea.getCurrTextIndex() == 0;
    }
}
