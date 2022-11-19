package managers;

import database.data_managers.AreaDataManager;
import database.data_objects.AreaData;
import objects.Area;
import objects.MultiDirectionalArea;
import objects.OneWayArea;

import java.util.ArrayList;
import java.util.HashMap;

public class AreaManager {

    private ArrayList<Area> areas;
    private AreaDataManager database;
    private String currentZone;
    private Area currentArea;

    public AreaManager() {
        this.database = new AreaDataManager();
        this.currentZone = "Introduction";
        this.areas = new ArrayList<>();
        ArrayList<AreaData> areaList = this.database.fetchAreaList(this.currentZone);
        for (AreaData areaData : areaList) {
            Area newArea = createArea(areaData);
            this.areas.add(newArea);
        }
    }

    private Area createArea(AreaData data) {
        if (data.type.equals("One-Way")) {
            Area newArea = new OneWayArea(
                    data.name,
                    data.speaker,
                    data.texts,
                    data.next
            );
            for (Area area : areas) {
                if (area.name.equals(data.next)) {
                    newArea.adjacentAreas.add(area);
                }
            }
            this.areas.add(newArea);
            return newArea;
        } else if (data.type.equals("Multi-Directional")) {
            Area newArea = new MultiDirectionalArea(
                    data.name,
                    data.speaker,
                    data.texts,
                    data.options
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

    public Area setNewArea(String name) {
        AreaData data = this.database.fetchArea(currentZone, name);
        this.currentArea = this.createArea(data);
        return this.currentArea;
    }

    public Area getCurrentArea() {
        return this.currentArea;
    }

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
        return this.currentArea;
    }
}
