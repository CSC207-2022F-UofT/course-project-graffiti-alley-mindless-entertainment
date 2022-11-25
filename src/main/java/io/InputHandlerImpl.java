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
            String choice = input.next().toLowerCase();
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
            OutputHandlerImpl screen = OutputHandlerImpl.getScreen();
            String msg = validator.getErrorMessage(choice);
            screen.generateText(msg);
            screen.generateText("Your choice is not valid. Please attempt again.");
            String text = screen.getLastText();
            List<String> options = screen.getLastOptions();
            if (options == null) {
                screen.generateText(text);
            } else {
                screen.generateTextWithOptions(text, options);
            }

        }
    }

}

