package game;

import io.InputHandler;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * These tests are scenario tests. They can be used to mock user input
 * and output the results to the console.
 * If the console is unavailable, a mock OutputHandler can also be created
 * in order to save output to a file.
 * While it would be very hard to maintain what should be correct,
 * a human user can look at the output to see if it is correct at a glance.
 * Scenario tests can also be used to find runtime exceptions.
 */
class GameTest {

    @Test
    void startGame() {
        List<String> input = List.of("exit");
        InputHandler mockInputHandler = new MockInputHandler(input);
        Game game = new Game(mockInputHandler);
        game.startGame();
    }
}