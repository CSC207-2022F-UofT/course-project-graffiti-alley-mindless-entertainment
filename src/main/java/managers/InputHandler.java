package managers;

import interfaces.Input;
import interfaces.InputValidator;

import java.util.Scanner;

public class InputHandler implements Input {

    /**
     * @param validator from wherever is calling input
     * @return a valid user input
     */
    @Override
    public String getChoice(InputValidator validator) {
        Scanner input = new Scanner(System.in);
        while (true) {
            String choice = input.next();
            String parsed = validator.parseAndValidate(choice);
            if (parsed != null) {
                return parsed;
            }
            OutputHandler screen = OutputHandler.getScreen();
            screen.generateText("Your choice is not valid. Please attempt your choice again.");
        }
    }

}

