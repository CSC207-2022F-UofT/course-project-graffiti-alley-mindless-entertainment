package options;



/*
The options of the game. A data storage class.
*/
public class Options {
    private int textSpeed = 1;
    private boolean enableAutoSave = true;

    private static Options instance;

    public static Options getOptions() {
        if (instance == null) {
            instance = new Options();
        }
        return instance;
    }

    private Options() {}

    public int getTextSpeed() {
        return textSpeed;
    }

    public boolean isEnableAutoSave() {
        return enableAutoSave;
    }

    public void setTextSpeed(int textSpeed) {
        this.textSpeed = textSpeed;
    }

    public void setEnableAutoSave(boolean enableAutoSave) {
        this.enableAutoSave = enableAutoSave;
    }
}
