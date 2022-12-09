package pause_menu.options;

/**
 * Factory design pattern for creating options.
 */
public class ChangeOptionsStateFactory {

    private final Options options;

    public ChangeOptionsStateFactory(Options options) {
        this.options = options;
    }
    public ChangeOptionsState createChangeOptionsState() {
        return new ChangeOptionsState(options);
    }
}
