package io;

import java.util.List;

/**
 * Entity used to store a message to send with the outputHandler.
 * Mainly used with getLastMessage() in order to consolidate text and options.
 * variables are final because they do not need to be set after constructor.
 */
public class Message {


    private final String text;
    private final List<String> options;

    public Message(String text, List<String> options) {
        this.text = text;
        this.options = options;
    }

    public String getText() {
        return text;
    }

    public List<String> getOptions() {
        return options;
    }
}
