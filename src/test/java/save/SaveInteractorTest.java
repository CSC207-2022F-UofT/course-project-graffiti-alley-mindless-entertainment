package save;

import game.GameEntities;
import objects.battle.skills.SkillType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SaveInteractorTest {

    @Test
    void testSave() {
        TestSaveGateway saveGateway = new TestSaveGateway();
        GameEntities gameEntities = new GameEntities();
        SaveInteractor saveInteractor = new SaveInteractor(3, saveGateway);
        saveInteractor.addSavableEntity(gameEntities.getInventory().new SaveInventory());
        saveInteractor.addSavableEntity(gameEntities.getOptions().new SaveOptions());
        saveInteractor.addSavableEntity(gameEntities.getPlayer().new SavePlayer());
        gameEntities.getPlayer().changeSkillType(SkillType.WATER);
        saveInteractor.saveAtSlot(1);
        boolean load = saveInteractor.loadFromSlot(1);
        Assertions.assertTrue(load);
        String slotsStatus = saveInteractor.getSlotsStatus();
        String expected = "Saves: \n" + "Slot #0: autosave\n" + "Slot #1: occupied\n" +
                "Slot #2: vacant\n" + "Slot #3: vacant\n";
        Assertions.assertEquals(slotsStatus, expected);
    }
}