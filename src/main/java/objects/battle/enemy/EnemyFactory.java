package objects.battle.enemy;

import objects.battle.Skill;
import objects.battle.SkillType;
import objects.battle.enemy.ai.DefaultAI;
import objects.battle.enemy.ai.EnemyAI;
import objects.battle.enemy.ai.SmartAI;
import objects.battle.enemy.gimmick.*;
import objects.character.Boss;
import objects.character.Enemy;
import objects.battle.enemy.EnemyInfo;

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

        EnemyInfo enemyInfo = new EnemyInfo(skills, speed, reputation, type);

        EnemyAI AItype;
        String ai = enemyData.ai;
        AIData aiData = databaseManager.fetchAIData(ai);
        if (Objects.equals(ai, "Smart")) {
            AItype = new SmartAI(enemyInfo, aiData.chance);
        } else{
            AItype = new DefaultAI(enemyInfo, aiData.chance);
        }
        return new Enemy(name, enemyInfo, AItype);
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

        EnemyInfo enemyInfo = new EnemyInfo(skills, speed, reputation, type);

        EnemyAI AItype;
        String ai = bossData.ai;
        AIData aiData = databaseManager.fetchAIData(ai);
        if (Objects.equals(ai, "Smart")) {
            AItype = SmartAI(enemyInfo, aiData.chance);
        } else{
            AItype = DefaultAI(enemyInfo, aiData.chance);
        }

        String gimmick_str = bossData.gimmick;
        Gimmick gimmick = translateGimmick(gimmick_str, enemyInfo);

        return new Boss(name, enemyInfo, AItype, gimmick);
    }

    public static SkillType translateSkill(String name){
        switch (name){
            case "water":{
                return SkillType.WATER;
            }
            case "fire":{
                return SkillType.FIRE;

            }
            case "grass":{
                return SkillType.EARTH;

            }
            case "air":{
                return SkillType.AIR;

            }
        }
        return SkillType.WATER;
    }

    public static Gimmick translateGimmick(String name, EnemyInfo enemyInfo){
        switch (name) {
            case "health":{
                return new HealthGimmick(enemyInfo);
            }
            case "attack":{
                return new AttackGimmick(enemyInfo);
            }
            case "speed":{
                return new SpeedGimmick(enemyInfo);
            }
            case "type":{
                return new TypeGimmick(enemyInfo);
            }
        }
        return new HealthGimmick(enemyInfo);
    }


}
