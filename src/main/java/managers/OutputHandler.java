package managers;

import interfaces.Output;

import java.util.Arrays;
import java.util.List;


public class OutputHandler implements Output {

    private static OutputHandler screen;

    /**
     * using Singleton pattern so that globally there is only one OutputHandler instance, which is screen
     */
    private OutputHandler() {}
    public static OutputHandler getScreen() {
        if (screen == null) {
            screen = new OutputHandler();
        }
        return screen;
    }

    /**
     * @param text to be displayed on screen
     * Display text on screen
     */
    @Override
    public void generateText(String text) {
        System.out.println(text);
    }

    /**
     * @param text and options to be displayed on screen
     * Display text and options on screen
     */
    @Override
    public void generateTextWithOptions(String text, List<String> options) {
        System.out.println(text);
        List<String> opt = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
                "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
        int cnt = 0;
        for (String option: options) {
            System.out.println(opt.get(cnt ++) + ". " + option);
        }
    }
}

