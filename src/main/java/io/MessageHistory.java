package io;

/**
 * Entity used to store message history.
 * Currently only stores the last message.
 */
public class MessageHistory {
    private Message message;

    /**
     * @param m the message to store
     */
    public void storeMessage(Message m) {
        message = m;
    }

    /**
     * @return the stored message
     */
    public Message getMessage() {
        return message;
    }
}
