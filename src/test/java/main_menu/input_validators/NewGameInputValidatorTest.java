package main_menu.input_validators;

import org.junit.jupiter.api.Test;

class NewGameInputValidatorTest {

    @Test
    void parseAndValidate() {
        NewGameInputValidator validator = new NewGameInputValidator();
        assert(validator.parseAndValidate("no") == null);
        assert(validator.parseAndValidate("") == null);
        assert(validator.parseAndValidate("new") == null);
        assert(validator.parseAndValidate("start").equals("start"));
        assert(validator.parseAndValidate("START").equals("start"));
        assert(validator.parseAndValidate("sTART").equals("start"));
        assert(validator.parseAndValidate("return").equals("return"));
        assert(validator.parseAndValidate("RETURN").equals("return"));
    }

    @Test
    void getErrorMessage() {
    }
}