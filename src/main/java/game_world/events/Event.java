package game_world.events;

import core.State;


public abstract class Event implements State {

    /**
     * Main Event class with arbitrary instance attributes
     */

    public String name;
    public String type;

}
