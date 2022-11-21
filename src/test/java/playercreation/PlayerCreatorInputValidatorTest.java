package playercreation;

import org.junit.jupiter.api.Test;


class PlayerCreatorInputValidatorTest {

    @Test
    void parseAndValidateNameCases() {
        PlayerCreatorInputValidator a = new PlayerCreatorInputValidator(PlayerQuestion.NAME);
        assert(a.parseAndValidate("") == null);
        assert(a.parseAndValidate("   ") == null);
        assert(a.parseAndValidate("myname").equals("myname"));
        assert(a.parseAndValidate("MyName").equals("myname"));
        assert(a.parseAndValidate("12345678901234567890").equals("12345678901234567890"));
        assert(a.parseAndValidate("1234567890123456789012") == null);
    }

    @Test
    void parseAndValidateDescriptionCases() {
        PlayerCreatorInputValidator a = new PlayerCreatorInputValidator(PlayerQuestion.DESCRIPTION);
        assert(a.parseAndValidate("") == null);
        assert(a.parseAndValidate("   ") == null);
        assert(a.parseAndValidate("mydescription").equals("mydescription"));
        assert(a.parseAndValidate("MyDescription").equals("mydescription"));
        assert(a.parseAndValidate("123456789").equals("123456789"));
    }

    @Test
    void parseAndValidateSkillTypeCases() {
        PlayerCreatorInputValidator a = new PlayerCreatorInputValidator(PlayerQuestion.SKILLTYPE);
        assert(a.parseAndValidate("air").equals("air"));
        assert(a.parseAndValidate("fire").equals("fire"));
        assert(a.parseAndValidate("water").equals("water"));
        assert(a.parseAndValidate("earth").equals("earth"));
        assert(a.parseAndValidate("Earth").equals("earth"));
        assert(a.parseAndValidate("no") == null);
        assert(a.parseAndValidate("") == null);
    }

    @Test
    void validateInputConfirmCases() {
        PlayerCreatorInputValidator a = new PlayerCreatorInputValidator(PlayerQuestion.CONFIRM);
        assert(a.parseAndValidate("confirm").equals("confirm"));
        assert(a.parseAndValidate("return").equals("return"));
        assert(a.parseAndValidate("CONFIRM").equals("confirm"));
        assert(a.parseAndValidate("Return").equals("return"));
        assert(a.parseAndValidate("") == null);
        assert(a.parseAndValidate("no") == null);
    }
}