package database.entities;

public class QuestGiverEventData {

    /**
     * All information needed for an encounter event
     */

    public final String name;
    public final String type;
    public final String quest;
    public final String npc;

    public QuestGiverEventData(String name, String type, String quest, String npc) {
        this.name = name;
        this.type = type;
        this.quest = quest;
        this.npc = npc;
    }

}

