package io;

public class Output {
    public static Output instance;

    public static OutputHandler getScreen() {
        return instance.outputHandler;
    }

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
