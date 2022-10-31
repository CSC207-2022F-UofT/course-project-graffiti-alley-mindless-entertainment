package options;

public class Options {
    private int textSpeed;
    private int textSize;
    private boolean enableAutoSave;

    public int getTextSpeed() {
        return textSpeed;
    }

    public int getTextSize() {
        return textSize;
    }

    public boolean isEnableAutoSave() {
        return enableAutoSave;
    }

    public void setTextSpeed(int textSpeed) {
        this.textSpeed = textSpeed;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    public void setEnableAutoSave(boolean enableAutoSave) {
        this.enableAutoSave = enableAutoSave;
    }
}
