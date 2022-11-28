package io;

import java.util.List;

public interface OutputHandler {


    /**
     * @return the last question
     */
    public String getLastText();

    /**
     * @return the last question's options
     */
    public List<String> getLastOptions();

    /**
     * @param text to be displayed on screen
     * Display text on screen
     */
    public void generateText(String text);

    /**
     * @param text to be displayed on screen
     * @param options to be displayed on screen
     * Display text and options on screen
     */
    public void generateTextWithOptions(String text, List<String> options);
}

