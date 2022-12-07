package database.objects;

public class QuestGiverEventData {

    /**
     * All information needed for an encounter event
     */

    public String name;
    public String type;
    public String npc;
    public String quest;

    public QuestGiverEventData(String name, String type, String quest, String npc) {
        this.name = name;
        this.type = type;
        this.quest = quest;
        this.npc = npc;
    }

}

