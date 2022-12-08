package io;

/**
 * the class that handles output
 */
public class Output {

    /**
     * instance: the only instance this Output class have
     */
    public static Output instance;

    /**
     * @return the screen instance of OutputHandler that is in charge of printing output
     */
    public static OutputHandler getScreen() {
        return getInstance().outputHandler;
    }

    /**
     * @return this Output instance
     */
    public static Output getInstance() {
        if (instance == null) {
            instance = new Output();
            instance.setOutputHandler(new OutputHandlerImpl());
        }
        return instance;
    }

    public void setOutputHandler(OutputHandler outputHandler) {
        this.outputHandler = outputHandler;
    }

    private OutputHandler outputHandler;
    private Output() {}
}
