package interfaces;

import java.util.List;

public interface OutputHandler {

    /**
     * @param text to be displayed on screen
     * Display text on screen
     */
    public void generateText(String text);

    /**
     * @param text and options to be displayed on screen
     * Display text and options on screen
     */
    public void generateTextWithOptions(String text, List<String> options);
}

