package managers;

import interfaces.InputValidator;

import java.util.Scanner;

public class InputHandler{

    String getChoice(InputValidator validator) {
        Scanner input = new Scanner(System.in);
        while (true) {
            String choice = input.next();
            if (validator.validateInput(choice)) {
                return choice;
            }
            OutputHandler output = new OutputHandler();
            output.generateText("Your choice is not valid. Please attempt your choice again.");
        }
    }
}
