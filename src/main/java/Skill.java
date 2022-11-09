import java.util.Dictionary;
import java.util.Hashtable;

public class Skill {
    public static Dictionary<String, Skill> allSkills = new Hashtable<>();
    private String name; // Name of the skill that the user sees
    private int damage; // Raw amount of damage dealt
    private int lag; // Changes speed of character for a turn after using a skill
    private String type; // Type of the skill

    public Skill(String name, int damage, int lag, String type) {
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
        return allSkills.get(skill_name);
    }
}
