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
        NewGameInputValidator validator = new NewGameInputValidator();
        assert(validator.getErrorMessage("start") == null);
        assert(validator.getErrorMessage("return") == null);
        assert(validator.getErrorMessage("").equals
                ("Please choose to start the game or return to the main menu."));
        assert(validator.getErrorMessage("a").equals
                ("Please choose to start the game or return to the main menu."));
    }
}