package menus.options;

import options.Options;

class ChangeOptionsStateTest {

    @org.junit.jupiter.api.Test
    void testPreInput() {
        Options options = Options.getOptions();
        ChangeOptionsState s = new ChangeOptionsState(options);
        s.preInput();
        assert(s.awaitInput());
        assert(!s.isDone());
    }

    @org.junit.jupiter.api.Test
    void testPostInputTextSpeed() {
        Options options = Options.getOptions();
        ChangeOptionsState s = new ChangeOptionsState(options);
        s.preInput();
        s.postInput("change textSpeed 3");
        assert(options.getTextSpeed() == 3);
        assert(!s.awaitInput());
        assert(!s.isDone());
    }

    @org.junit.jupiter.api.Test
    void testPostInputTextSpeedInvalid() {
        Options options = Options.getOptions();
        ChangeOptionsState s = new ChangeOptionsState(options);
        int valBefore = options.getTextSpeed();
        s.preInput();
        s.postInput("change textSpeed abc");
        assert(options.getTextSpeed() == valBefore);
        assert(s.awaitInput());
        assert(!s.isDone());
    }

    @org.junit.jupiter.api.Test
    void testPostInputAutoSave() {
        Options options = Options.getOptions();
        ChangeOptionsState s = new ChangeOptionsState(options);
        s.preInput();
        s.postInput("change autoSave false");
        assert(!options.isEnableAutoSave());
        assert(!s.awaitInput());
        assert(!s.isDone());
    }

    @org.junit.jupiter.api.Test
    void testPostInputAutoSaveInvalid() {
        Options options = Options.getOptions();
        ChangeOptionsState s = new ChangeOptionsState(options);
        boolean valBefore = options.isEnableAutoSave();
        s.preInput();
        s.postInput("change autoSave sad");
        assert(options.isEnableAutoSave() == valBefore);
        assert(s.awaitInput());
        assert(!s.isDone());
    }

    @org.junit.jupiter.api.Test
    void testPostInputQuit() {
        Options options = Options.getOptions();
        ChangeOptionsState s = new ChangeOptionsState(options);
        s.preInput();
        s.postInput("return");
        assert(s.isDone());
    }

    @org.junit.jupiter.api.Test
    void testPostInputEmptyString() {
        Options options = Options.getOptions();
        ChangeOptionsState s = new ChangeOptionsState(options);
        s.preInput();
        s.postInput("");
        assert(s.awaitInput());
        assert(!s.isDone());
    }
}