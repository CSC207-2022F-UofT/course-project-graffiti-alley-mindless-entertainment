package objects.battle;

import java.util.ArrayList;
import java.util.List;

public class Skill {
    /** A class for all skills to be used by any kinds of Characters in battles.
     * Attributes:
     * name: A string representing the name of the skill
     * damage: An integer representing how much damage the skill does
     * lag: An integer that adds priority to skills
     * type: enum representing the element of the skill, introduces type advantages.
     */
    private String name;
    private int damage;
    private int lag;
    private SkillType type;

    public Skill() {
        this.name = "dummy";
        this.damage = 0;
        this.lag = 0;
        this.type = SkillType.WATER;
    }
    public Skill(String name, int damage, int lag, SkillType type) {
        // Allows for creation and customization of skills
        this.name = name;
        this.damage = damage;
        this.lag = lag;
        this.type = type;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getDamage() {
        return this.damage;
    }
    
    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    public int getLag() {
        return this.lag;
    }
    
    public void setLag(int lag) {
        this.lag = lag;
    }
    
    public SkillType getType() {return this.type;}
    
    public void setType(SkillType type) {
        this.type = type;
    }

    /**
     * Gives a String list representing the corresponding list of type Skills
     * @param skillList List of type Skill wanted to be turned into a string
     * @return String of the names of each skill in skillList
     */
    public List<String> toSkillString(List<Skill> skillList) {
        List<String> stringSkills = new ArrayList<>();
        for (Skill skill : skillList) {
            stringSkills.add(skill.getName());
        }
        return stringSkills;
    }

    /**
     * Finds and returns the Skill wanted in a list of skills. Returns Dummy skill if not found
     * @param skillName name of skill to find
     * @param skillList list of skills to look through
     * @return either Dummy skill or the corresponding skill needed
     */
    public Skill findSkill(String skillName, List<Skill> skillList) {
        Skill correctSkill = new Skill();
        for (Skill skill : skillList) {
            if (skill.getName().equals(skillName)) {
                correctSkill = skill;
            }
        }
        return correctSkill;
    }
}
