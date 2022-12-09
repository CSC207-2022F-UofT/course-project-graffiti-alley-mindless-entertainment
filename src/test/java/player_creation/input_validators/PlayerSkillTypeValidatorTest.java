package player_creation.input_validators;

import org.junit.jupiter.api.Test;

class PlayerSkillTypeValidatorTest {

    @Test
    void parseAndValidate() {
        PlayerSkillTypeValidator a = new PlayerSkillTypeValidator();
        assert(a.parseAndValidate("air").equals("air"));
        assert(a.parseAndValidate("fire").equals("fire"));
        assert(a.parseAndValidate("water").equals("water"));
        assert(a.parseAndValidate("earth").equals("earth"));
        assert(a.parseAndValidate("Earth").equals("earth"));
        assert(a.parseAndValidate("no") == null);
        assert(a.parseAndValidate("") == null);
    }

    @Test
    void getErrorMessageCases() {
        PlayerSkillTypeValidator a = new PlayerSkillTypeValidator();
        assert(a.getErrorMessage("not a skill type").equals
                ("Please type a valid skill type: Air, Earth, Fire, or Water."));
        assert(a.getErrorMessage("air") == null);
        assert(a.getErrorMessage("earth") == null);
        assert(a.getErrorMessage("fire") == null);
        assert(a.getErrorMessage("water") == null);
    }
}