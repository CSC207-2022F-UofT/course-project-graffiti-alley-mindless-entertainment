package game_world.objects.events;

import interfaces.State;


public abstract class Event implements State {

    /**
     * Main Area class with arbitrary instance attributes
     */

    public String name;
    public String type;

    public long priority;
    public int eventState;

    /**
     * Main abstract method, executes all code within an event
     */
    public void execute() {};

}
