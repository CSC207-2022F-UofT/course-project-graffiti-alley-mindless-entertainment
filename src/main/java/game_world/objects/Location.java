package game_world.objects;

import game_world.managers.AreaDatabaseInteractor;
import game_world.objects.events.Event;
import save.SavableEntity;
import save.SaveEntityId;

import java.util.ArrayList;

public class Location implements SavableEntity {

    private Area currentArea;
    private AreaDatabaseInteractor databaseController;

    public Area getCurrentArea() {
        return currentArea;
    }

    public void setCurrentArea(Area currentArea) {
        this.currentArea = currentArea;
    }

    public void setDatabaseController(AreaDatabaseInteractor databaseController) {
        this.databaseController = databaseController;
    }

    @Override
    public String toSavableString() {
        if (currentArea.getCurrEvent() == null)
            return currentArea.getId() + "/NA";
        return currentArea.getId() + "/" + currentArea.getCurrEvent().name;
    }

    @Override
    public void fromSavableString(String str) {
        String[] ids = str.split("/");
        this.currentArea = databaseController.loadArea(ids[0]);
        if (!ids[1].equals("NA")) {
            ArrayList<Event> events = this.currentArea.getEvents();
            for (int i = 0; i < events.size(); i++) {
                if (events.get(i).name.equals(ids[1]))
                    this.currentArea.setCurrEventIndex(i);
            }
        }
    }

    @Override
    public SaveEntityId getId() {
        return SaveEntityId.LOCATION;
    }
}
