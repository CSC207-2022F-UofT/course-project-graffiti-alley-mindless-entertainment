package options;


import save.SavableEntity;
import save.SaveEntityId;

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

    public class SaveOptions implements SavableEntity {

        /**
         * @return a string representation of the object to be saved
         */
        @Override
        public String toSavableString() {
            return enableAutoSave + " " + textSpeed;
        }

        /**
         * @param str a string representation
         *            map the string representation to the corresponding object
         */
        @Override
        public void fromSavableString(String str) {
            String[] splitString = str.split(" ");
            enableAutoSave = Boolean.parseBoolean(splitString[0]);
            textSpeed = Integer.parseInt(splitString[1]);
        }

        /**
         * @return the id of this entity in the saved entities list
         */
        @Override
        public SaveEntityId getId() {
            return SaveEntityId.Options;
        }
    }
}
