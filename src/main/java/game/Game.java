package game;

import io.InputHandler;
import io.InputHandlerImpl;

public class Game {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandlerImpl();
        Shell s = new Shell(inputHandler);
        s.startGame();

    }
}
