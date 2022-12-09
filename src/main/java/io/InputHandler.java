package io;

public interface InputHandler {

    /**
     * @param validator from wherever is calling input
     * @return a valid user input
     */
    String getChoice(InputValidator validator);
}

