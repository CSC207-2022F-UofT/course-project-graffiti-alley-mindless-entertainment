package game;

import io.InputHandler;
import io.InputValidator;
import io.Output;

import java.util.List;

public class MockInputHandler implements InputHandler {

    int currIndex;

    List<String> inputText;

    public MockInputHandler(List<String> inputText) {
        this.inputText = inputText;
    }

    /**
     * @param validator from wherever is calling input
     * @return a valid user input
     */
    @Override
    public String getChoice(InputValidator validator) {
        if (currIndex >= inputText.size()) {
            return "exit";
        }
        String ret = inputText.get(currIndex);
        Output.getScreen().generateText("\u001b[33m" + ret + "\u001b[30m");
        currIndex += 1;
        return ret;
    }

    public void resetInput(List<String> inputText) {
        this.inputText = inputText;
        this.currIndex = 0;
    }
}
