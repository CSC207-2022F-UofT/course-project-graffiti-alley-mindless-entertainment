package game_world.entities;

import game_world.use_cases.AreaDatabaseInteractor;
import game_world.events.Event;
import save.entities.SavableEntity;
import save.entities.SaveEntityId;

import java.util.ArrayList;
import java.util.Objects;

public class Location {

    private Area currentArea;

    public Area getCurrentArea() {
        return currentArea;
    }

    public void setCurrentArea(Area currentArea) {
        this.currentArea = currentArea;
    }

    public Event getCurrEvent() {
        if (currentArea == null) {return null; }
        else {return currentArea.getCurrEvent();}
    }
    public class SaveLocation implements SavableEntity {

        public SaveLocation(AreaDatabaseInteractor databaseController) {
            this.databaseController = databaseController;
        }

        private final AreaDatabaseInteractor databaseController;
        @Override
        public String toSavableString () {
            if (currentArea == null) {return "";}
            if (currentArea.getCurrEvent() == null)
                return currentArea.getId() + "/NA";
            return currentArea.getId() + "/" + currentArea.getCurrEvent().name;
        }

        @Override
        public void fromSavableString (String str){
            if (Objects.equals(str, "")) {currentArea = null; return;}
            String[] ids = str.split("/");
            currentArea = databaseController.loadArea(ids[0]);
            if (!ids[1].equals("NA")) {
                ArrayList<Event> events = currentArea.getEvents();
                for (int i = 0; i < events.size(); i++) {
                    if (events.get(i).name.equals(ids[1]))
                        currentArea.setCurrEventIndex(i);
                }
            }
        }

        @Override
        public SaveEntityId getId () {
            return SaveEntityId.LOCATION;
        }
    }


}
