package playercreation.input_validators;

import org.junit.jupiter.api.Test;

class PlayerDescriptionValidatorTest {

    @Test
    void parseAndValidateCases() {
        PlayerDescriptionValidator a = new PlayerDescriptionValidator();
        assert(a.parseAndValidate("") == null);
        assert(a.parseAndValidate("mydescription").equals("mydescription"));
        assert(a.parseAndValidate("MyDescription").equals("mydescription"));
        assert(a.parseAndValidate("123456789").equals("123456789"));
        assert(a.parseAndValidate("|") == null);
    }

    @Test
    void getErrorMessageCases() {
        PlayerDescriptionValidator a = new PlayerDescriptionValidator();
        assert(a.getErrorMessage("").equals("Please type a valid description."));
        assert(a.getErrorMessage("nice description") == null);
        assert(a.getErrorMessage("|").equals("| is not a supported character. Please try again."));
    }
}