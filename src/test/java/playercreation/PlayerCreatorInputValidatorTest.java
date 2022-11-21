package playercreation;

import org.junit.jupiter.api.Test;


class PlayerCreatorInputValidatorTest {

    @Test
    void validateInputNameCases() {
        PlayerCreatorInputValidator a = new PlayerCreatorInputValidator(PlayerQuestion.NAME);
        assert(!a.validateInput(""));
        assert(!a.validateInput("   "));
        assert(a.validateInput("myname"));
        assert(a.validateInput("12345678901234567890"));
        assert(!a.validateInput("1234567890123456789012"));
    }

    @Test
    void validateInputDescriptionCases() {
        PlayerCreatorInputValidator a = new PlayerCreatorInputValidator(PlayerQuestion.DESCRIPTION);
        assert(!a.validateInput(""));
        assert(!a.validateInput("   "));
        assert(a.validateInput("mydescription"));
    }

    @Test
    void validateInputSkillTypeCases() {
        PlayerCreatorInputValidator a = new PlayerCreatorInputValidator(PlayerQuestion.SKILLTYPE);
        assert(a.validateInput("air"));
        assert(a.validateInput("fire"));
        assert(a.validateInput("water"));
        assert(a.validateInput("earth"));
        assert(!a.validateInput("no"));
        assert(!a.validateInput(""));
    }

    @Test
    void validateInputConfirmCases() {
        PlayerCreatorInputValidator a = new PlayerCreatorInputValidator(PlayerQuestion.CONFIRM);
        assert(a.validateInput("confirm"));
        assert(a.validateInput("return"));
        assert(!a.validateInput(""));
        assert(!a.validateInput("no"));
    }
}