package database.objects;

public class EncounterEventData {

    /**
     * All information needed for an encounter event
     */

    public String name;
    public String type;
    public String encounterType;
    public String npc;
    public String questName;

    public EncounterEventData(String name, String type, String encounterType, String npc, String questName) {
        this.name = name;
        this.type = type;
        this.encounterType = encounterType;
        this.npc = npc;
        this.questName = questName;
    }

}

