package game_world;

import database.factories.QuestGiverEventFactory;
import game_world.factories.AreaFactory;
import game_world.factories.EventFactory;
import game_world.factories.ItemPickUpEventFactory;
import game_world.managers.*;
import game_world.entities.Location;
import character.entities.Player;
import game_world.use_cases.AreaDatabaseInteractor;
import game_world.use_cases.EventDatabaseInteractor;
import inventory.entities.Inventory;
import org.junit.jupiter.api.Test;
import quests.QuestInteractor;

public class EventManagerTest {

    @Test
    void testEventManagerMethods() {
        Inventory inventory = new Inventory();
        ItemPickUpEventFactory itemPickUpEventFactory = new ItemPickUpEventFactory(inventory);
        QuestInteractor questInteractor = new QuestInteractor(new Player("", null));
        QuestGiverEventFactory questGiverEventFactory = new QuestGiverEventFactory(questInteractor);
        EventFactory eventFactory = new EventFactory(itemPickUpEventFactory, questGiverEventFactory);
        EventDatabaseInteractor eventDatabaseInteractor = new EventDatabaseInteractor(eventFactory);
        EventManager eventManager = new EventManager();
        AreaFactory areaFactory = new AreaFactory(eventDatabaseInteractor);
        AreaDatabaseInteractor areaDatabaseInteractor = new AreaDatabaseInteractor(areaFactory);
        AreaManager areaManager = new AreaManager(eventManager, areaDatabaseInteractor, new Location(), null);
        areaManager.initialize();
        areaManager.getAreaUseCase().getToNextArea("2");
        eventManager.areaEntered(areaManager.getAreaUseCase().getCurrentArea());
        assert !eventManager.queueCleared();
    }

}
