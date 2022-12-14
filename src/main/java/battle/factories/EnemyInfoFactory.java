package battle.factories;

import database.managers.SkillDataManager;
import database.entities.EnemyData;
import database.entities.SkillData;
import battle.entities.Skill;
import battle.entities.SkillType;
import battle.entities.EnemyInfo;
import battle.entities.EnemyPotion;

import java.util.ArrayList;

/**
 * This class creates the EnemyInfo of the enemy with the given name
 * using the information in the database
 */
public class EnemyInfoFactory {

    /**
     * skillDataManager: Manager used to get the information about the skill from the database
     */
    private final SkillDataManager skillDataManager;

    public EnemyInfoFactory(SkillDataManager skillDataManager){
        this.skillDataManager = skillDataManager;
    }
    /**
     * This method returns the EnemyInfo that the enemy with the name in the database has.
     * @param enemyData Enemy data from the database
     * @return EnemyInfo of the enemy with the name given
     */
    public EnemyInfo createEnemyInfo(EnemyData enemyData){
        ArrayList<Skill> skills = new ArrayList<>();
        for (String i:enemyData.skills) {
            SkillData skillData = this.skillDataManager.fetchSkillData(i);
            int damage = Integer.parseInt(skillData.damage);
            String skillType = skillData.type;
            SkillType type = translateSkill(skillType);
            int lag = Integer.parseInt(skillData.lag);
            Skill skill = new Skill(i, damage, lag, type);
            skills.add(skill);
        }
        int reputation = Integer.parseInt(enemyData.reputation);
        int speed = Integer.parseInt(enemyData.speed);
        int potion = Integer.parseInt(enemyData.potion);

        String typeStr = enemyData.type;
        SkillType type = translateSkill(typeStr);

        return new EnemyInfo(skills, speed, reputation, type, new EnemyPotion(potion));
    }

    /**
     * This method returns the type gimmick depending on the string in the database
     * @param name of the skill
     * @return skill with the name and all the other attributes in the database
     */
    public SkillType translateSkill(String name){
        switch (name){
            case "water":{
                return SkillType.WATER;
            }
            case "fire":{
                return SkillType.FIRE;

            }
            case "earth":{
                return SkillType.EARTH;

            }
            case "air":{
                return SkillType.AIR;

            }
        } return SkillType.WATER;
    }
}
