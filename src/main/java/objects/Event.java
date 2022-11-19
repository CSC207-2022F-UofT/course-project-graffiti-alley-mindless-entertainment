package objects;

public abstract class Event {

    /**
     * Main Area class with arbitrary instance attributes
     */

    public String name;
    public String type;

    public int priority;
    public int eventState;

    /**
     * Main abstract method, executes all code within an event
     */
    public void execute() {};

}
