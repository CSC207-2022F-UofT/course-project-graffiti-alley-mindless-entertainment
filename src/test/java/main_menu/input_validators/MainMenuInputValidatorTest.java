package main_menu.input_validators;

import org.junit.jupiter.api.Test;

class MainMenuInputValidatorTest {

    @Test
    void parseAndValidate() {
        MainMenuInputValidator validator = new MainMenuInputValidator();
        assert(validator.parseAndValidate("no") == null);
        assert(validator.parseAndValidate("") == null);
        assert(validator.parseAndValidate("new").equals("new"));
        assert(validator.parseAndValidate("NEW").equals("new"));
        assert(validator.parseAndValidate("nEW").equals("new"));
        assert(validator.parseAndValidate("load").equals("load"));
        assert(validator.parseAndValidate("LOAD").equals("load"));
        assert(validator.parseAndValidate("lOAD").equals("load"));
    }

    @Test
    void getErrorMessage() {
    }
}