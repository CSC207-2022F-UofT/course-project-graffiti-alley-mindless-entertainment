package database.objects;

public class EncounterEventData {

    /**
     * All information needed for an encounter event
     */

    public String name;
    public String type;
    public String encounterType;
    public String npc;

    public EncounterEventData(String name, String type, String encounterType, String npc) {
        this.name = name;
        this.type = type;
        this.encounterType = encounterType;
        this.npc = npc;
    }

}

