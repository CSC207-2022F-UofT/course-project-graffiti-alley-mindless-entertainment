package options;

import java.util.Objects;

class OptionsTest {
    @org.junit.jupiter.api.Test
    public void testToSavableString() {
        Options options = Options.getOptions();
        Options.SaveOptions saveOptions = options.new SaveOptions();
        options.setEnableAutoSave(false);
        options.setTextSpeed(5);
        String savableString = saveOptions.toSavableString();
        assert(Objects.equals(savableString, "false 5"));
        saveOptions.fromSavableString(savableString);
    }

    @org.junit.jupiter.api.Test
    public void testFromSavableString() {
        Options options = Options.getOptions();
        Options.SaveOptions saveOptions = options.new SaveOptions();
        saveOptions.fromSavableString("false 5");
        assert(!options.isEnableAutoSave());
        assert(options.getTextSpeed() == 5);
    }
}