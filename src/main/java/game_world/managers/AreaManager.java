package game_world.managers;

import core.StateManager;
import database.managers.AreaDataManager;
import database.objects.AreaData;
import game_world.objects.areas.Area;
import game_world.objects.areas.MultiDirectionalArea;
import game_world.objects.areas.OneWayArea;
import interfaces.State;

import java.util.ArrayList;

public class AreaManager extends StateManager {

    /**
     * Manages all matters regarding Areas
     */

    private ArrayList<Area> areas;
    private AreaDataManager database;
    private EventManager eventManager;
    private String currentZone;
    private Area currentArea;

    public AreaManager(EventManager eventManager) {
        this.database = new AreaDataManager();
        this.eventManager = eventManager;
        initialize();
    }

    @Override
    protected State nextState(String input) {
        return null;
    }

    @Override
    public void initialize() {
        this.currentZone = "Introduction";
        this.areas = new ArrayList<>();
        ArrayList<AreaData> areaList = this.database.fetchAreaList(this.currentZone);
        for (AreaData areaData : areaList) {
            Area newArea = createArea(areaData);
            this.areas.add(newArea);
        }
        this.currentArea = areas.get(0);
    }



    /**
     * Generates new Area object and adds to the areas list
     * @return the new area generated
     * @param data data from existing AreaData
     */
    private Area createArea(AreaData data) {
        if (data.type.equals("One-Way")) {
            Area newArea = new OneWayArea(
                    data.name,
                    data.speaker,
                    data.texts,
                    data.next,
                    eventManager.getEventsFromArea(data.events)
            );
            for (Area area : areas) {
                if (area.name.equals(data.next)) {
                    newArea.adjacentAreas.add(area);
                }
            }
            this.areas.add(newArea);
            return newArea;
        }
        else if (data.type.equals("Multi-Directional")) {
            Area newArea = new MultiDirectionalArea(
                    data.name,
                    data.speaker,
                    data.texts,
                    data.options,
                    eventManager.getEventsFromArea(data.events)
            );
            ArrayList<String> nextList = new ArrayList<>();
            for (String next : data.options.values()) {
                nextList.add(next.split(" - ")[1]);
            }
            for (Area area : areas) {
                if (nextList.contains(data.name)) {
                    newArea.adjacentAreas.add(area);
                }
            }
            this.areas.add(newArea);
            return newArea;
        }
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
                Area newArea = createArea(areaData);
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
