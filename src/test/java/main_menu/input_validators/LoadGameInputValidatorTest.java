package main_menu.input_validators;

import org.junit.jupiter.api.Test;
import save.SaveInteractor;

class LoadGameInputValidatorTest {

    @Test
    void parseAndValidate() {
        SaveInteractor saveInteractor = new SaveInteractor(2);
        LoadGameInputValidator validator = new LoadGameInputValidator(saveInteractor);
        assert(validator.parseAndValidate("no") == null);
        assert(validator.parseAndValidate("") == null);
        assert(validator.parseAndValidate("new") == null);
        assert(validator.parseAndValidate("return").equals("return"));
        assert(validator.parseAndValidate("RETURN").equals("return"));
    }

    @Test
    void getErrorMessage() {
    }
}