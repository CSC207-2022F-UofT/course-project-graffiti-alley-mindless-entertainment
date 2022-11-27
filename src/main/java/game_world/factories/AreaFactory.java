package game_world.factories;

import database.objects.AreaData;
import game_world.managers.EventManager;
import game_world.objects.areas.Area;
import game_world.objects.areas.MultiDirectionalArea;
import game_world.objects.areas.OneWayArea;

import java.util.ArrayList;

public class AreaFactory {

    private EventManager eventManager;

    public AreaFactory(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    /**
     * Generates new Area object and adds to the areas list
     * @return the new area generated
     * @param data data from existing AreaData
     */

    public Area createArea(ArrayList<Area> areas, AreaData data) {
        if (data.type.equals("One-Way")) {
            Area newArea = new OneWayArea(
                    data.name,
                    data.speaker,
                    data.texts,
                    data.next,
                    this.eventManager.getEventsFromArea(data.events)
            );
            for (Area area : areas) {
                if (area.getName().equals(data.next)) {
                    newArea.addAdjacentArea(area);
                }
            }
            areas.add(newArea);
            return newArea;
        }
        else if (data.type.equals("Multi-Directional")) {
            Area newArea = new MultiDirectionalArea(
                    data.name,
                    data.speaker,
                    data.texts,
                    data.options,
                    this.eventManager.getEventsFromArea(data.events)
            );
            ArrayList<String> nextList = new ArrayList<>();
            for (String next : data.options.values()) {
                nextList.add(next.split(" - ")[1]);
            }
            for (Area area : areas) {
                if (nextList.contains(data.name)) {
                    newArea.addAdjacentArea(area);
                }
            }
            areas.add(newArea);
            return newArea;
        }
        return null;
    }

}
