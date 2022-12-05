package game_world.objects.events;

import quests.*;

/**
 *
 */
public class QuestEvent extends Event {

    /**
     * Attributes.
     */
    // Stores
    public final QuestFactory questFactory;

    /**
     * Constructor.
     *
     * @param name: name of the event.
     * @param priority:
     */
    QuestEvent(String name, long priority) {
        this.name = name;
        this.type = "Quest";
        this.priority = priority;
        this.eventState = 0;
        this.questFactory = new QuestFactory();
    }

    /**
     *
     */
    @Override
    public void execute() {
        // search through the
        // .
    }

    /**
     * Fetches the quest in the
     * @return
     */
    private Quest fetchQuest() {
        return null;
    }
}
