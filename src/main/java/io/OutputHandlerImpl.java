package io;

import java.util.Arrays;
import java.util.List;


public class OutputHandlerImpl implements OutputHandler {

    private final MessageHistory messageHistory;

    /**
     * using Singleton pattern so that globally there is only one OutputHandler instance, which is screen
     */
    public OutputHandlerImpl() {
        messageHistory = new MessageHistory();
    }

    /**
     * @return the last question's options
     */
    @Override
    public Message getLastMessage() {
        return messageHistory.getMessage();
    }

    /**
     * @param text to be displayed on screen
     * Display text on screen
     */
    @Override
    public void generateText(String text) {
        Message m = new Message(text, null);
        messageHistory.storeMessage(m);
        System.out.println(text);
    }

    /**
     * @param text to be displayed on screen
     * @param options to be displayed on screen
     * Display text and options on screen
     */
    @Override
    public void generateTextWithOptions(String text, List<String> options) {
        if (options == null) {
            generateText(text);
            return;
        }
        Message m = new Message(text, options);
        messageHistory.storeMessage(m);
        System.out.println(text);
        List<String> opt = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
                "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
        int cnt = 0;
        for (String option: options) {
            System.out.println(opt.get(cnt ++) + ". " + option);
        }
    }

    /**
     * Used in case a message object is generated by getLastMessage.
     * Other overloaded methods are present for more flexibility.
     * Displays the message on screen.
     * @param message the message to display
     */
    @Override
    public void generateText(Message message) {
        if (message == null) {
            return;
        }
        generateTextWithOptions(message.getText(), message.getOptions());
    }
}

