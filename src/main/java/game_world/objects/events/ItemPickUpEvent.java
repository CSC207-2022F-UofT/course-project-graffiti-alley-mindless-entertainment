package game_world.objects.events;

public class ItemPickUpEvent extends Event {

    /**
     * Event executes when there is an item to be picked up (to be implemented)
     */

    public ItemPickUpEvent(String name, long priority) {
        this.name = name;
        this.type = "Item Pick-Up";
        this.priority = priority;
        this.eventState = 0;
    }

    @Override
    public void execute() {

    }

}
