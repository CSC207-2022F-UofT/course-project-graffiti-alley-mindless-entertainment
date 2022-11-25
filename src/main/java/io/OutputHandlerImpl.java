package io;

import java.util.Arrays;
import java.util.List;


public class OutputHandlerImpl implements OutputHandler {

    private String text=null;
    private List<String> options=null;

    /**
     * using Singleton pattern so that globally there is only one OutputHandler instance, which is screen
     */
    public OutputHandlerImpl() {}

    /**
     * @return the last question
     */
    @Override
    public String getLastText() { return text; }

    /**
     * @return the last question's options
     */
    @Override
    public List<String> getLastOptions() {
        return options;
    }

    /**
     * @param text to be displayed on screen
     * Display text on screen
     */
    @Override
    public void generateText(String text) {
        this.text = text;
        this.options = null;
        System.out.println(text);
    }

    /**
     * @param text to be displayed on screen
     * @param options to be displayed on screen
     * Display text and options on screen
     */
    @Override
    public void generateTextWithOptions(String text, List<String> options) {
        this.text = text;
        this.options = options;
        System.out.println(text);
        List<String> opt = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
                "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
        int cnt = 0;
        for (String option: options) {
            System.out.println(opt.get(cnt ++) + ". " + option);
        }
    }
}

