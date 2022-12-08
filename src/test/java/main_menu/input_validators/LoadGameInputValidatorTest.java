package main_menu.input_validators;

import org.junit.jupiter.api.Test;
import save.SaveGatewayImpl;
import save.SaveInteractor;

class LoadGameInputValidatorTest {

    @Test
    void parseAndValidate() {
        SaveGatewayImpl gatewayImpl = new SaveGatewayImpl();
        SaveInteractor saveInteractor = new SaveInteractor(2, gatewayImpl);
        LoadGameInputValidator validator = new LoadGameInputValidator(saveInteractor);
        assert(validator.parseAndValidate("no") == null);
        assert(validator.parseAndValidate("") == null);
        assert(validator.parseAndValidate("new") == null);
        assert(validator.parseAndValidate("return").equals("return"));
        assert(validator.parseAndValidate("RETURN").equals("return"));
    }

    @Test
    void getErrorMessage() {
        SaveGatewayImpl gatewayImpl = new SaveGatewayImpl();
        SaveInteractor saveInteractor = new SaveInteractor(2, gatewayImpl);
        LoadGameInputValidator validator = new LoadGameInputValidator(saveInteractor);
        assert(validator.getErrorMessage("1") == null);
        assert(validator.getErrorMessage("return") == null);
        assert(validator.getErrorMessage("no").equals
                ("Please choose to open a valid save file or return to the main menu."));
        assert(validator.getErrorMessage("4").equals
                ("Please choose to open a valid save file or return to the main menu."));
    }
}