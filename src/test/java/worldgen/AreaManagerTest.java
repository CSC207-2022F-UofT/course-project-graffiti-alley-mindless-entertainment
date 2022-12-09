package worldgen;

import database.factories.QuestGiverEventFactory;
import game_world.factories.*;
import game_world.managers.*;
import game_world.objects.Location;
import game_world.objects.states.DialogueState;
import game_world.objects.states.SelectionState;
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
        EventManager eventManager = new EventManager();
        AreaFactory areaFactory = new AreaFactory(eventDatabaseInteractor);
        AreaDatabaseInteractor areaDatabaseInteractor = new AreaDatabaseInteractor(areaFactory);
        AreaManager areaManager = new AreaManager(eventManager, areaDatabaseInteractor, new Location(), null);
        areaManager.initialize();
        assert areaManager.getAreaUseCase().getCurrentArea().getName().equals("[GAME]");
        areaManager.getAreaUseCase().getToNextArea("2");
        assert areaManager.getAreaUseCase().getCurrentArea().getName().equals("Beach 1");
        assert areaManager.getAreaUseCase().checkForAreaEntered();
        assert areaManager.getAreaUseCase().checkForValidInput("walk along the beach");
        DialogueStateFactory dialogueStateFactory = new DialogueStateFactory();
        DialogueState dialogueState = dialogueStateFactory.createDialogueState(
                areaManager.getAreaUseCase().getCurrentArea()
        );
        assert (!dialogueState.isDone());
        SelectionStateFactory selectionStateFactory = new SelectionStateFactory();
        SelectionState selectionState = selectionStateFactory.createSelectionState(
                areaManager.getAreaUseCase().getCurrentArea().getNextInputs()
        );
        assert (!selectionState.isDone());
    }

}
