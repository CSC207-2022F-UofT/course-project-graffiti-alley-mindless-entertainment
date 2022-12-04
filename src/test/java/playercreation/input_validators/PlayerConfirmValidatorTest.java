package playercreation.input_validators;

import org.junit.jupiter.api.Test;

class PlayerConfirmValidatorTest {

    @Test
    void parseAndValidateCases() {
        PlayerConfirmValidator a = new PlayerConfirmValidator();
        assert(a.parseAndValidate("confirm").equals("confirm"));
        assert(a.parseAndValidate("return").equals("return"));
        assert(a.parseAndValidate("CONFIRM").equals("confirm"));
        assert(a.parseAndValidate("Return").equals("return"));
        assert(a.parseAndValidate("") == null);
        assert(a.parseAndValidate("no") == null);
    }
}