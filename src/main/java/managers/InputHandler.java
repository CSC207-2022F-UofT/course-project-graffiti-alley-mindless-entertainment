package managers;

import com.sun.corba.se.spi.orbutil.fsm.Input;
import interfaces.InputValidator;

import java.util.Scanner;

public class InputHandler{

    String getChoice(InputValidator validator) {
        while (true) {
            Scanner input = new Scanner(System.in);
            String choice = input.next();
            if (validator.validateInput(choice)) {
                return choice;
            }
            OutputHandler output = new OutputHandler();
            output.generateText("Your choice is not valid. Please attempt your choice again.");
        }
    }
}
