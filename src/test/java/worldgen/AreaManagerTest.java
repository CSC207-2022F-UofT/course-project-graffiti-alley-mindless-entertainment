package worldgen;

import database.factories.QuestGiverEventFactory;
import game_world.factories.EventFactory;
import game_world.factories.ItemPickUpEventFactory;
import game_world.managers.*;
import game_world.objects.Location;
import objects.character.Player;
import objects.inventory.Inventory;
import org.junit.jupiter.api.Test;
import quests.QuestInteractor;

public class AreaManagerTest {

    @Test
    void testAreaManagerMethods() {
        Inventory inventory = new Inventory();
        ItemPickUpEventFactory itemPickUpEventFactory = new ItemPickUpEventFactory(inventory);
        QuestInteractor questInteractor = new QuestInteractor(new Player("", null));
        QuestGiverEventFactory questGiverEventFactory = new QuestGiverEventFactory(questInteractor);
        EventFactory eventFactory = new EventFactory(itemPickUpEventFactory, questGiverEventFactory);
        EventDatabaseInteractor eventDatabaseInteractor = new EventDatabaseInteractor(eventFactory);
        EventManager eventManager = new EventManager(eventDatabaseInteractor);
        AreaDatabaseInteractor areaDatabaseInteractor = new AreaDatabaseInteractor(eventManager);
        AreaManager areaManager = new AreaManager(eventManager, areaDatabaseInteractor, new Location());
        assert areaManager.getAreaUseCase().getCurrentArea().getName().equals("[GAME]");
        areaManager.getAreaUseCase().getToNextArea("2");
        assert areaManager.getAreaUseCase().getCurrentArea().getName().equals("Beach 1");
        assert areaManager.getAreaUseCase().checkForAreaEntered();
        assert areaManager.getAreaUseCase().checkForValidInput("walk along the beach");
    }

}
