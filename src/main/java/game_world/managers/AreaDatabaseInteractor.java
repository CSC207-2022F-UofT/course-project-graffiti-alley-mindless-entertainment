package game_world.managers;

import database.managers.AreaDataManager;
import database.objects.AreaData;
import game_world.factories.AreaFactory;
import game_world.objects.Area;

public class AreaDatabaseInteractor {

    /**
     * Interactor with AreaDatabase for AreaManager
     */

    private final AreaDataManager database;
    private final AreaFactory areaFactory;

    public AreaDatabaseInteractor(AreaFactory areaFactory) {
        this.database = new AreaDataManager();
        this.areaFactory = areaFactory;
    }

    /**
     * @param id of next Area to be loaded
     * @return new Area created by AreaFactory
     */

    public Area loadArea(String id) {
        AreaData areaData = this.database.fetchArea(id);
        return this.areaFactory.createArea(areaData);
    }
}
