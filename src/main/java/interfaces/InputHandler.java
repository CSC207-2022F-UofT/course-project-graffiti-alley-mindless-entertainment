package interfaces;

public interface InputHandler {

    /**
     * @param validator from wherever is calling input
     * @return a valid user input
     */
    public String getChoice(InputValidator validator);
}

