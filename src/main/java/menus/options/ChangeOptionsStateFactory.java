package menus.options;

import options.Options;

/**
 * Factory design pattern for creating options.
 */
public class ChangeOptionsStateFactory {
    public ChangeOptionsState createChangeOptionsState() {
        Options options = Options.getOptions();
        return new ChangeOptionsState(options);
    }
}
