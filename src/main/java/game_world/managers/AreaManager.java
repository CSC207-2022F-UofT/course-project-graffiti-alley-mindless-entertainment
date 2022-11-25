package game_world.managers;

import core.StateManager;
import database.managers.AreaDataManager;
import database.objects.AreaData;
import game_world.factories.AreaFactory;
import game_world.objects.areas.Area;
import game_world.objects.areas.MultiDirectionalArea;
import game_world.objects.areas.OneWayArea;
import interfaces.State;

import java.util.ArrayList;

public class AreaManager extends StateManager {

    /**
     * Manages all matters regarding Areas
     */

    private final AreaFactory factory;
    private final AreaDataManager database;
    private final EventManager eventManager;

    private String currentZone;
    private Area currentArea;
    private ArrayList<Area> areas;

    public AreaManager(EventManager eventManager) {
        this.database = new AreaDataManager();
        this.eventManager = eventManager;
        this.factory = new AreaFactory(this.eventManager);
        this.currentZone = "Introduction";
        initialize();
    }

    @Override
    public void initialize() {
        boolean areaInit = false;
        this.areas = new ArrayList<>();
        ArrayList<AreaData> areaList = this.database.fetchAreaList(this.currentZone);

        for (AreaData areaData : areaList) {
            Area newArea = this.factory.createArea(this.areas, areaData);
            this.areas.add(newArea);
            if (newArea.name.equals(this.currentArea.name)) {areaInit = true;}
        }

        // Initialize to first area of zone
        if (!areaInit) {
            this.currentArea = areas.get(0);
        }
    }

    @Override
    protected State nextState(String input) {
        if (input.equals("move"))
        return null;
    }

    /**
     * @return currentArea of Player
     */
    public Area getCurrentArea() {
        return this.currentArea;
    }

    /**
     * @return area from current zone
     */
    private Area getArea(String name) {
        for (Area area : areas) {
            if (area.name.equals(name)) {
                return area;
            }
        }
        return null;
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
                if (area.name.equals(nextArea)) {
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
                Area newArea = this.factory.createArea(areas, areaData);
                if (newArea.name.equals(nextArea)) {
                    this.currentArea = newArea;
                }
                areas.add(newArea);
            }
        }
        eventManager.areaEntered(this.currentArea);
        return this.currentArea;
    }

}
