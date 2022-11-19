package menus.options;

import core.GameState;
import options.Options;

public class ChangeOptionsStateFactory {
    public ChangeOptionsState createChangeOptionsState() {
        Options options = Options.getOptions();
        return new ChangeOptionsState(options);
    }
}
