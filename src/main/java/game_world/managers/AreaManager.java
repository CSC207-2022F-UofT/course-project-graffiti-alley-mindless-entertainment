package game_world.managers;

import core.StateManager;
import database.managers.AreaDataManager;
import database.objects.AreaData;
import game_world.factories.AreaFactory;
import game_world.factories.DialogueStateFactory;
import game_world.factories.SelectionStateFactory;
import game_world.objects.areas.Area;
import interfaces.State;
import io.Output;
import io.OutputHandler;

import java.util.ArrayList;

public class AreaManager extends StateManager {

    /**
     * Manages all matters regarding Areas
     */

    private final AreaFactory areaFactory;
    private final DialogueStateFactory dialogueStateFactory = new DialogueStateFactory();
    private final SelectionStateFactory selectionStateFactory = new SelectionStateFactory();
    private final AreaDataManager database;
    private final EventManager eventManager;

    private String currentZone;
    private Area currentArea;
    private ArrayList<Area> areas;

    public AreaManager(EventManager eventManager) {
        this.database = new AreaDataManager();
        this.eventManager = eventManager;

        this.areaFactory = new AreaFactory(this.eventManager);
        this.currentZone = "Introduction";
        initialize();
    }

    @Override
    public void initialize() {
        this.areas = new ArrayList<>();
        ArrayList<AreaData> areaList = this.database.fetchAreaList(this.currentZone);

        for (AreaData areaData : areaList) {
            Area newArea = this.areaFactory.createArea(this.areas, areaData);
            this.areas.add(newArea);
        }

        // Initialize to first area of zone
        this.currentArea = areas.get(0);
        this.currState = dialogueStateFactory.createDialogueState(
                "The game will now begin. To advance dialogue, press enter. Enjoy!"
        );
    }

    @Override
    protected State nextState(String input) {
        OutputHandler output = Output.getScreen();
        if (this.currentArea.getCurrTextIndex() == 0) {
            output.generateText("◈ " + this.currentArea.getSpeaker() + "");
        }
        if (this.currentArea.getCurrTextIndex() == this.currentArea.getTexts().size()) {
            if (this.currentArea.getEvents().size() == 0) {
                if (this.currentArea.getType().equals("One-Way")) {
                    String nextAreaName = this.currentArea.getNextAreas().get(0);
                    this.getToNextArea(nextAreaName);
                    this.currState = dialogueStateFactory.createDialogueState(
                            "You approach " + nextAreaName.split(" - ")[1] + " in " + nextAreaName.split(" - ")[0] + "."
                    );
                    return this.currState;
                } else if (this.currentArea.getType().equals("Multi-Directional")) {
                    if (this.currentArea.getNextInputs().contains(input.toLowerCase())) {
                        this.getToNextArea(this.currentArea.getAreaFromInput(input.toLowerCase()));
                        this.currState = dialogueStateFactory.createDialogueState(
                                "You approach " + this.currentArea.getName() + " in " + this.currentZone + "."
                        );
                    }
                    else {
                        this.currState = selectionStateFactory.createSelectionState(this.currentArea.getNextInputs());
                    }
                    return this.currState;
                }
            }
            else {
                // play events
                eventManager.areaEntered(this.currentArea);
                this.currState = null;
            }
        }
        else {
            this.currState = dialogueStateFactory.createDialogueState(
                    this.currentArea.getTexts().get(this.currentArea.getCurrTextIndex())
            );
            this.currentArea.incrementCurrTextIndex();
        }
        return this.currState;
    }

    /**
     * @return currentArea of Player
     */
    public Area getCurrentArea() {
        return this.currentArea;
    }

    /**
     * Checks if zone must be changed, if not, changes currentArea to next area defined
     * Otherwise, clears current areas list and refreshes area manager with new zone data and
     * returns new area from next zone
     * Also executes event queue from next area
     * @return next area
     */
    public Area getToNextArea(String choice) {
        String nextArea = choice.split(" - ")[1];
        String zone = choice.split(" - ")[0];
        if (this.currentZone.equals(zone)) {
            for (Area area : areas) {
                if (area.getName().equals(nextArea)) {
                    this.currentArea = area;
                    break;
                }
            }
        }
        else {
            // Reset Zone
            this.areas.clear();
            this.currentZone = zone;
            ArrayList<AreaData> areaList = this.database.fetchAreaList(this.currentZone);
            for (AreaData areaData : areaList) {
                Area newArea = this.areaFactory.createArea(areas, areaData);
                if (newArea.getName().equals(nextArea)) {
                    this.currentArea = newArea;
                }
                areas.add(newArea);
            }
        }
        return this.currentArea;
    }

}
