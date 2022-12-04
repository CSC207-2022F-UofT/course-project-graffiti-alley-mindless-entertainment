package playercreation.input_validators;

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
}