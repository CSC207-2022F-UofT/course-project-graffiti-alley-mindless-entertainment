package switch_managers;


/**
 * This is a proxy for the switchEventMediator.
 * Could have been implemented by adding a switchEventMediator instance to every class that needed it
 * However this is a lot of work, so this singleton was chosen instead.
 */
public class SwitchEventMediatorProxy implements SwitchEventMediator {

    private static SwitchEventMediatorProxy instance;

    /**
     * @return Get the instance of the switchEventMediatorProxy globally
     */
    public static SwitchEventMediator getInstance() {
        if (instance == null) {
            instance = new SwitchEventMediatorProxy();
            instance.service = new SwitchEventMediatorImpl();
        }
        return instance;
    }

    /**
     * Private constructor to prevent instantiating
     */
    private SwitchEventMediatorProxy() {}

    private SwitchEventMediator service;

    /**
     * @param service the implementation to direct requests to.
     */
    public void setService(SwitchEventMediator service) {
        this.service = service;
    }

    /**
     * @param switchEventType Stores a switchEventType for later use
     */
    @Override
    public void store(SwitchEventType switchEventType) {
        service.store(switchEventType);
    }

    /**
     * @return Whether there is a stored SwitchEventType
     */
    @Override
    public boolean ready() {
        return service.ready();
    }

    /**
     * @return the stored switchEventType. Delete once accessed.
     */
    @Override
    public SwitchEventType retrieve() {
        return service.retrieve();
    }
}
