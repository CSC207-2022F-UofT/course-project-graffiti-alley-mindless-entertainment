package playercreation;

import objects.battle.SkillType;
import org.junit.jupiter.api.Test;

class PlayerCreatorInteractorTest {

    @Test
    void addNameCases() {
        PlayerCreatorInteractor a = new PlayerCreatorInteractor();
        a.addName("");
        assert(a.getNewPlayer().getName().isEmpty());
        a.addName("MyName");
        assert(a.getNewPlayer().getName().equals("MyName"));
    }

    @Test
    void addDescriptionCases() {
        PlayerCreatorInteractor a = new PlayerCreatorInteractor();
        a.addDescription("");
        assert(a.getNewPlayer().getDescription().isEmpty());
        a.addDescription("MyDescription");
        assert(a.getNewPlayer().getDescription().equals("MyDescription"));
    }

    @Test
    void addSkillTypeCases() {
        PlayerCreatorInteractor a = new PlayerCreatorInteractor();
        a.addSkillType(SkillType.FIRE);
        assert(a.getNewPlayer().getSkillType() == SkillType.FIRE);
        a.addSkillType(SkillType.AIR);
        assert(a.getNewPlayer().getSkillType() == SkillType.AIR);
    }

    @Test
    void savePlayer() {
        // Awaiting saving functionality.
    }
}