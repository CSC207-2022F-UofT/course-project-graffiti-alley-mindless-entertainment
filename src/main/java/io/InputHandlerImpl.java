package io;

import io.InputValidator;

import java.util.Scanner;
import java.util.List;

public class InputHandlerImpl implements InputHandler {

    /**
     * @param validator validator from whichever class that is calling InputHandler
     * @return a valid user input
     */
    @Override
    public String getChoice(InputValidator validator) {
        Scanner input = new Scanner(System.in);
        while (true) {
            String choice = input.nextLine().toLowerCase();
            if (choice.equals("exit") || choice.equals("pause")) {
                return choice;
            }
            if (validator == null) {
                return choice;
            }
            String parsed = validator.parseAndValidate(choice);
            if (parsed != null) {
                return parsed;
            }
            String msg = validator.getErrorMessage(choice);
            Output.getScreen().generateText(msg);
            Output.getScreen().generateText("Your choice is not valid. Please attempt again.");
            String text = Output.getScreen().getLastText();
            List<String> options = Output.getScreen().getLastOptions();
            if (options == null) {
                Output.getScreen().generateText(text);
            } else {
                Output.getScreen().generateTextWithOptions(text, options);
            }

        }
    }

}

