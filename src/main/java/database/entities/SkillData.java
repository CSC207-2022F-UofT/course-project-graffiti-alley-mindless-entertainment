package database.entities;

public class SkillData {

    /**
     * All information needed for a skill
     */

    public final String name;
    public final String type;
    public final String lag;
    public final String damage;

    public SkillData(String name, String type, String lag, String damage) {
        this.name = name;
        this.type = type;
        this.lag = lag;
        this.damage = damage;
    }
}

