package game_world.events;

import core.State;


public abstract class Event implements State {

    /**
     * Main Area class with arbitrary instance attributes
     */

    public String name;
    public String type;

    /**
     * Main abstract method, executes all code within an event
     */

}