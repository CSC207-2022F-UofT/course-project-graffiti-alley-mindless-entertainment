package managers;

import database.data_managers.AreaDataManager;
import database.data_objects.AreaData;
import objects.Area;
import objects.MultiDirectionalArea;
import objects.OneWayArea;

import java.util.ArrayList;
import java.util.HashMap;

public class AreaManager {

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
        this.currentZone = "Introduction";
        this.eventManager = eventManager;
        this.areas = new ArrayList<>();
        ArrayList<AreaData> areaList = this.database.fetchAreaList(this.currentZone);
        for (AreaData areaData : areaList) {
            Area newArea = createArea(areaData);
            this.areas.add(newArea);
        }
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
    public Area getArea(String name) {
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
    public Area getToNextArea(String choice, String zone) {
        if (this.currentZone.equals(zone)) {
            for (Area area : areas) {
                if (area.name.equals(choice)) {
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
                if (newArea.name.equals(choice)) {
                    this.currentArea = newArea;
                }
                areas.add(newArea);
            }
        }
        eventManager.areaEntered(this.currentArea);
        return this.currentArea;
    }

}
