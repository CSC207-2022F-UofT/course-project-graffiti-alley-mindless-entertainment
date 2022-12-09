package objects.battle.skills;

import java.util.ArrayList;
import java.util.List;

public class SkillHelper {
    public SkillHelper() {

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
        Skill correctSkill = null;
        for (Skill skill : skillList) {
            if (skill.getName().equals(skillName)) {
                correctSkill = skill;
            }
        }
        return correctSkill;
    }
}
