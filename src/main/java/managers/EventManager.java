package managers;

import database.data_managers.DatabaseManager;
import objects.Event;

public class EventManager {

    private Event[] eventQueue;
    private DatabaseManager database;

    public EventManager(DatabaseManager database) {
        this.database = database;

    }
}
