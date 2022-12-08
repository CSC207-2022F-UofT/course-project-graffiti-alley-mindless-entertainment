package playercreation.input_validators;

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
}