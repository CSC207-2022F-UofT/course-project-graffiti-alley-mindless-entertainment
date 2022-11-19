package Battle.Enemy_system;

import objects.character.Boss;
import objects.character.Enemy;
import Enemy_Entities.Gimmick;

import managers.DatabaseManager;
import java.util.ArrayList;
import java.util.Objects;

import data_objects.EnemyData;
import data_objects.SkillData;

public class EnemyFactory {

    /**
     * This method returns the enemy instance using the information given by database
     * @param name of the enemy to create
     * @return instance of enemy
     */
    public static Enemy getEnemy(String name){
        EnemyData enemyData = databaseManager.fetchEnemyData(name);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        for (String i:enemyData.skills) {
            SkillData skillData = databaseManager.fetchSkillData(i);
            int damage = skillData.damage;
            String skillType = skillData.type;
            SkillType type = translateSkill(skillType);
            int lag = skillData.lag;
            Skill skill = new Skill(i, damage, lag, type);
            skills.add(skill);
        }
        int reputation = enemyData.reputation;
        int speed = enemyData.speed;

        String typeStr = enemyData.type;
        SkillType type = translateSkill(typeStr);

        EnemyInfo enemyInfo = new EnemyInfo(name, skills, speed, reputation, type);

        EnemyAI AItype;
        String ai = enemyData.ai;
        AIData aiData = databaseManager.fetchAIData(ai);
        if (Objects.equals(ai, "Smart")) {
            AItype = SmartAI(enemyInfo, aiData.chance);
        } else{
            AItype = DefaultAI(enemyInfo, aiData.chance);
        }
        Enemy enemy = new Enemy(name, enemyInfo, AItype);
        return enemy;
    }

    /**
     * This method returns the boss instance using the information given by database
     * @param name of the boss to create
     * @return instance of boss
     */
    public static Boss getBoss(String name){
        BossData bossData = databaseManager.fetchEnemyData(name);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        for (String i:bossData.skills) {
            SkillData skillData = databaseManager.fetchSkillData(i);
            int damage = skillData.damage;
            String skillType = skillData.type;
            SkillType type = translateSkill(skillType);
            int lag = skillData.lag;
            Skill skill = new Skill(i, damage, lag, type);
            skills.add(skill);
        }
        int reputation = bossData.reputation;
        int speed = bossData.speed;
        String typeStr = bossData.type;
        SkillType type = translateSkill(typeStr);

        EnemyInfo enemyInfo = new EnemyInfo(name, skills, speed, reputation, type);

        EnemyAI AItype;
        String ai = bossData.ai;
        AIData aiData = databaseManager.fetchAIData(ai);
        if (Objects.equals(ai, "Smart")) {
            AItype = SmartAI(enemyInfo, aiData.chance);
        } else{
            AItype = DefaultAI(enemyInfo, aiData.chance);
        }

        String gimmick_str = bossData.gimmick;
        Gimmick gimmick = translateGimmick(gimmick_str);

        Boss boss = new Boss(name, enemyInfo, AItype, gimmick);
        return boss;
    }

    public static SkillType translateSkill(String name){
        switch (name){
            case "water":{
                return new SkillType.WATER;
                break;
            }
            case "fire":{
                return new SkillType.FIRE;

                break;
            }
            case "grass":{
                return new SkillType.GRASS;

                break;
            }
            case "air":{
                return new SkillType.AIR;

                break;
            }
        }
        return new SkillType.WATER;
    }

    public static Gimmick translateGimmick(String name){
        switch (name) {
            case "health":{
                return new HealthGimmick(enemyInfo);
                break;
            }
            case "attack":{
                return new AttackGimmick(enemyInfo);
                break;
            }
            case "speed":{
                return new SpeedGimmick(enemyInfo);
                break;
            }
            case "type":{
                return new TypeGimmick(enemyInfo);
                break;
            }
        }
        return new HealthGimmick(enemyInfo);
    }


}
