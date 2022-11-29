package objects.battle.enemy.factory;

import database.managers.EnemyDataManager;
import database.managers.SkillDataManager;
import database.objects.EnemyData;
import database.objects.SkillData;
import objects.battle.Skill;
import objects.battle.SkillType;
import objects.battle.enemy.EnemyInfo;

import java.util.ArrayList;

public class EnemyInfoFactory {

    private final EnemyDataManager enemyDataManager;
    private final SkillDataManager skillDataManager;

    public EnemyInfoFactory(EnemyDataManager enemyDataManager, SkillDataManager skillDataManager){
        this.enemyDataManager = enemyDataManager;
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

        String typeStr = enemyData.type;
        SkillType type = translateSkill(typeStr);

        return new EnemyInfo(skills, speed, reputation, type);
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
