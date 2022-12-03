package main_menu;

import org.junit.jupiter.api.Test;

class MainMenuInputValidatorTest {

    @Test
    void parseAndValidateMainMenuCases() {
        MainMenuInputValidator validator = new MainMenuInputValidator(MainMenuOptions.MAINMENU);
        assert(validator.parseAndValidate("no") == null);
        assert(validator.parseAndValidate("") == null);
        assert(validator.parseAndValidate("new").equals("new"));
        assert(validator.parseAndValidate("NEW").equals("new"));
        assert(validator.parseAndValidate("nEW").equals("new"));
        assert(validator.parseAndValidate("load").equals("load"));
        assert(validator.parseAndValidate("LOAD").equals("load"));
        assert(validator.parseAndValidate("lOAD").equals("load"));
        assert(validator.parseAndValidate("quit").equals("quit"));
        assert(validator.parseAndValidate("QUIT").equals("quit"));
        assert(validator.parseAndValidate("qUIT").equals("quit"));
    }

    @Test
    void parseAndValidateNewCases() {
        MainMenuInputValidator validator = new MainMenuInputValidator(MainMenuOptions.NEW);
        assert(validator.parseAndValidate("no") == null);
        assert(validator.parseAndValidate("") == null);
        assert(validator.parseAndValidate("new") == null);
        assert(validator.parseAndValidate("start").equals("start"));
        assert(validator.parseAndValidate("START").equals("save"));
        assert(validator.parseAndValidate("sTART").equals("save"));
        assert(validator.parseAndValidate("return").equals("return"));
        assert(validator.parseAndValidate("RETURN").equals("return"));
    }

    @Test
    void parseAndValidateLoadCases() {
        MainMenuInputValidator validator = new MainMenuInputValidator(MainMenuOptions.LOAD);
        assert(validator.parseAndValidate("no") == null);
        assert(validator.parseAndValidate("") == null);
        assert(validator.parseAndValidate("new") == null);
        assert(validator.parseAndValidate("return").equals("return"));
        assert(validator.parseAndValidate("RETURN").equals("return"));
    }

    @Test
    void parseAndValidateQuitCases() {
        MainMenuInputValidator validator = new MainMenuInputValidator(MainMenuOptions.QUIT);
        assert(validator.parseAndValidate("no") == null);
        assert(validator.parseAndValidate("") == null);
        assert(validator.parseAndValidate("new") == null);
        assert(validator.parseAndValidate("return").equals("return"));
        assert(validator.parseAndValidate("RETURN").equals("return"));
        assert(validator.parseAndValidate("quit").equals("quit"));
        assert(validator.parseAndValidate("QUIT").equals("quit"));
    }
}