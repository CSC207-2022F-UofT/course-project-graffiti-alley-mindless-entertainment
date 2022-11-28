package switch_managers;

/**
 * Interface for switchEventMediator.
 * The purpose of this class is to mediate communication between the stateManagers and the shell.
 * The shell needs to know which switchEvent has been scheduled once the manager is done.
 * Uses the mediator design pattern.
 */
public interface SwitchEventMediator {


    /**
     * @param switchEventType Stores a switchEventType for later use
     */
    void store(SwitchEventType switchEventType);

    /**
     * @return the stored switchEventType. Delete once accessed.
     */
    SwitchEventType retrieve();

    /**
     * @return Whether there is a stored SwitchEventType
     */
    boolean ready();
}
