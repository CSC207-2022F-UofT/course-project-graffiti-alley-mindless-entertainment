import java.util.Dictionary;
import java.util.Hashtable;

public class Skill {
    /** A class for all skills to be used by any kinds of Characters in battles.
     * Attributes:
     * allSkills: A dictionary mapping the string name of a skill to the skill object itself
     * name: A string representing the name of the skill
     * damage: An integer representing how much damage the skill does
     * lag; An integer that adds priority to skills
     * type: String representing the element of the skill, introduces type advantages.
     */
    public static Dictionary<String, Skill> allSkills = new Hashtable<>();
    private String name;
    private int damage;
    private int lag;
    private String type;

    public Skill(String name, int damage, int lag, String type) {
        // Allows for creation and customization of skills
        this.name = name;
        this.damage = damage;
        this.lag = lag;
        this.type = type;
        allSkills.put(this.name, this); // Adds the new skill to the allSkills Dictionary
    }
    
    public String get_name() {
        return this.name;
    }
    
    public void set_name(String name) {
        this.name = name;
    }
    
    public int get_damage() {
        return this.damage;
    }
    
    public void set_damage(int damage) {
        this.damage = damage;
    }
    
    public int get_lag() {
        return this.lag;
    }
    
    public void set_lag(int lag) {
        this.lag = lag;
    }
    
    public String get_type() {
        return this.type;
    }
    
    public void set_type(String type) {
        this.type = type;
    }

    public static Skill find(String skill_name) {
        // Searches the allSkills dictionary to return the corresponding skill to a given name
        return allSkills.get(skill_name);
    }
}
