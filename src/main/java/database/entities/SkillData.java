package database.entities;

public class SkillData {

    /**
     * All information needed for a skill
     */

    public String name;
    public String type;
    public String lag;
    public String damage;

    public SkillData(String name, String type, String lag, String damage) {
        this.name = name;
        this.type = type;
        this.lag = lag;
        this.damage = damage;
    }
}
