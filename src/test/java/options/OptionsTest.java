package options;

import java.util.Objects;

class OptionsTest {
    @org.junit.jupiter.api.Test
    public void testToSavableString() {
        Options options = Options.getOptions();
        options.setEnableAutoSave(false);
        options.setTextSpeed(5);
        String savableString = options.toSavableString();
        assert(Objects.equals(savableString, "false 5"));
        options.fromSavableString(savableString);
    }

    @org.junit.jupiter.api.Test
    public void testFromSavableString() {
        Options options = Options.getOptions();
        options.fromSavableString("false 5");
        assert(!options.isEnableAutoSave());
        assert(options.getTextSpeed() == 5);
    }
}