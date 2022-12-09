package database.entities;

public class EncounterEventData {

    /**
     * All information needed for an encounter event
     */

    public final String name;
    public final String type;
    public final String encounterType;
    public final String npc;

    public EncounterEventData(String name, String type, String encounterType, String npc) {
        this.name = name;
        this.type = type;
        this.encounterType = encounterType;
        this.npc = npc;
    }

}

