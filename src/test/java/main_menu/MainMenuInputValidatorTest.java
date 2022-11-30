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
        assert(validator.parseAndValidate("save1").equals("save1"));
        assert(validator.parseAndValidate("SAVE1").equals("save1"));
        assert(validator.parseAndValidate("sAve1").equals("save1"));
        assert(validator.parseAndValidate("save2").equals("save2"));
        assert(validator.parseAndValidate("SAVE2").equals("save2"));
        assert(validator.parseAndValidate("save3").equals("save3"));
        assert(validator.parseAndValidate("SAVE3").equals("save3"));
        assert(validator.parseAndValidate("return").equals("return"));
        assert(validator.parseAndValidate("RETURN").equals("return"));
    }

    @Test
    void parseAndValidateLoadCases() {
        MainMenuInputValidator validator = new MainMenuInputValidator(MainMenuOptions.LOAD);
        assert(validator.parseAndValidate("no") == null);
        assert(validator.parseAndValidate("") == null);
        assert(validator.parseAndValidate("new") == null);
        assert(validator.parseAndValidate("save1").equals("save1"));
        assert(validator.parseAndValidate("SAVE1").equals("save1"));
        assert(validator.parseAndValidate("sAve1").equals("save1"));
        assert(validator.parseAndValidate("save2").equals("save2"));
        assert(validator.parseAndValidate("SAVE2").equals("save2"));
        assert(validator.parseAndValidate("save3").equals("save3"));
        assert(validator.parseAndValidate("SAVE3").equals("save3"));
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