package switch_managers;

/**
 * Implementation of SwitchEventMediator.
 */
public class SwitchEventMediatorImpl implements SwitchEventMediator{

    private SwitchEventType currType;

    /**
     * @param switchEventType Stores a switchEventType for later use
     */
    @Override
    public void store(SwitchEventType switchEventType) {
        currType = switchEventType;
    }

    /**
     * @return Whether there is a stored SwitchEventType
     */
    @Override
    public boolean ready() {
        return currType != null;
    }

    /**
     * @return the stored switchEventType. Delete once accessed.
     */
    @Override
    public SwitchEventType retrieve() {
        SwitchEventType saveType = currType;
        currType = null;
        return saveType;
    }
}
