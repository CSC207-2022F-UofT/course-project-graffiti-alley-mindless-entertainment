package player_creation;

import battle.entities.SkillType;
import character.entities.Player;
import org.junit.jupiter.api.Test;

class PlayerCreatorInteractorTest {

    @Test
    void addNameCases() {
        Player player = new Player("", null);
        PlayerCreatorInteractor a = new PlayerCreatorInteractor(player);
        a.addName("");
        assert(a.getNewPlayer().getName().isEmpty());
        a.addName("MyName");
        assert(a.getNewPlayer().getName().equals("MyName"));
    }

    @Test
    void addDescriptionCases() {
        Player player = new Player("", null);
        PlayerCreatorInteractor a = new PlayerCreatorInteractor(player);
        a.addDescription("");
        assert(a.getNewPlayer().getDescription().isEmpty());
        a.addDescription("MyDescription");
        assert(a.getNewPlayer().getDescription().equals("MyDescription"));
    }

    @Test
    void addSkillTypeCases() {
        Player player = new Player("", null);
        PlayerCreatorInteractor a = new PlayerCreatorInteractor(player);
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