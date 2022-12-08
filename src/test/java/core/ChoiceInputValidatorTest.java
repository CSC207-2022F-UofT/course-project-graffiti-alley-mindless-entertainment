package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChoiceInputValidatorTest {

    @Test
    void parseAndValidate() {
        List<String> allowedInputs = new ArrayList<>();
        allowedInputs.add("Test1");
        allowedInputs.add("test2");
        allowedInputs.add("TEST3");
        ChoiceInputValidator choiceInputValidator = new ChoiceInputValidator(allowedInputs);
        Assertions.assertEquals(choiceInputValidator.parseAndValidate("c"), "test3");
        Assertions.assertEquals(choiceInputValidator.parseAndValidate("test1"), "test1");
        Assertions.assertEquals(choiceInputValidator.parseAndValidate("b"), "test2");
    }

}