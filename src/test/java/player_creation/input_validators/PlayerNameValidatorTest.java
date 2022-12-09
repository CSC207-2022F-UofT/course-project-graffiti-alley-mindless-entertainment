package player_creation.input_validators;

import org.junit.jupiter.api.Test;

class PlayerNameValidatorTest {

    @Test
    void parseAndValidateCases() {
        PlayerNameValidator a = new PlayerNameValidator();
        assert(a.parseAndValidate("") == null);
        assert(a.parseAndValidate("myname").equals("myname"));
        assert(a.parseAndValidate("MyName").equals("myname"));
        assert(a.parseAndValidate("12345678901234567890").equals("12345678901234567890"));
        assert(a.parseAndValidate("1234567890123456789012") == null);
        assert(a.parseAndValidate("|") == null);
    }

    @Test
    void getErrorMessageCases() {
        PlayerNameValidator a = new PlayerNameValidator();
        assert(a.getErrorMessage("").equals("Please type a valid name."));
        assert(a.getErrorMessage("123456789012345678901").equals("Please make names 20 characters or less."));
        assert(a.getErrorMessage("nice name") == null);
        assert(a.getErrorMessage("|").equals("| is not a supported character. Please try again."));
    }
}