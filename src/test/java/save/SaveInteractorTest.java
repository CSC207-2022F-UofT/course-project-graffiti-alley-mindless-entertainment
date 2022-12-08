package save;

import game.Game;
import game.GameEntities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaveInteractorTest {

    @Test
    void testSave() {
        SaveGatewayImpl saveGateway = new SaveGatewayImpl();
        GameEntities gameEntities = new GameEntities();
        SaveInteractor saveInteractor = new SaveInteractor(3, saveGateway);
        saveInteractor.addSavableEntity(gameEntities.getLocation().new SaveLocation());
        saveInteractor.addSavableEntity(gameEntities.getInventory().new SaveInventory());
        saveInteractor.addSavableEntity(gameEntities.getOptions().new SaveOptions());
        saveInteractor.addSavableEntity(gameEntities.getPlayer().new SavePlayer());
        saveInteractor.saveAtSlot(1);
        boolean load = saveInteractor.loadFromSlot(1);
        Assertions.assertTrue(load);
        String slotsStatus = saveInteractor.getSlotsStatus();
        String expected = "Saves: \n" + "Slot #1: occupied\n" +
                "Slot #2: vacant\n" + "Slot #3: vacant\n";
        Assertions.assertEquals(slotsStatus, expected);
    }
}