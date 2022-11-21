package objects.battle.enemy;

import database.managers.AIDataManager;
import database.managers.EnemyDataManager;
import database.managers.SkillDataManager;
import database.objects.AIData;
import database.objects.EnemyData;
import database.objects.SkillData;
import objects.battle.Skill;
import objects.battle.SkillType;
import objects.battle.enemy.ai.DefaultAI;
import objects.battle.enemy.ai.EnemyAI;
import objects.battle.enemy.ai.SmartAI;
import objects.battle.enemy.gimmick.*;
import objects.character.Boss;
import objects.character.Enemy;


import java.util.ArrayList;
import java.util.Objects;


public class EnemyFactory {

    /**
     * This method returns the enemy instance using the information given by database
     * @param name of the enemy to create
     * @return instance of enemy
     */
    public static Enemy createEnemy(String name) throws Exception {
        EnemyDataManager data = new EnemyDataManager();
        EnemyData enemyData = data.fetchEnemyData(name);
        ArrayList<Skill> skills = new ArrayList<>();
        SkillDataManager dataSkill = new SkillDataManager();
        for (String i:enemyData.skills) {
            SkillData skillData = dataSkill.fetchSkillData(i);
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

        EnemyInfo enemyInfo = new EnemyInfo(skills, speed, reputation, type);

        EnemyAI AItype;
        String ai = enemyData.ai;
        AIDataManager dataAI = new AIDataManager();
        AIData aiData = dataAI.fetchAIData(ai);
        if (Objects.equals(ai, "smart")) {
            AItype = new SmartAI(enemyInfo, Integer.parseInt(aiData.chance));
        } else{
            AItype = new DefaultAI(enemyInfo, Integer.parseInt(aiData.chance));
        }
        return new Enemy(name, enemyInfo, AItype);
    }

    public static Enemy createBoss(String name) throws Exception {
        EnemyDataManager data = new EnemyDataManager();
        EnemyData enemyData = data.fetchEnemyData(name);
        ArrayList<Skill> skills = new ArrayList<>();
        SkillDataManager dataSkill = new SkillDataManager();
        for (String i:enemyData.skills) {
            SkillData skillData = dataSkill.fetchSkillData(i);
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

        EnemyInfo enemyInfo = new EnemyInfo(skills, speed, reputation, type);

        EnemyAI AItype;
        String ai = enemyData.ai;
        AIDataManager dataAI = new AIDataManager();
        AIData aiData = dataAI.fetchAIData(ai);
        if (Objects.equals(ai, "smart")) {
            AItype = new SmartAI(enemyInfo, Integer.parseInt(aiData.chance));
        } else{
            AItype = new DefaultAI(enemyInfo, Integer.parseInt(aiData.chance));
        }

        Gimmick gimmick = translateGimmick(enemyData.gimmick, enemyInfo);
        return new Boss(name, enemyInfo, AItype, gimmick);

    }

    public static SkillType translateSkill(String name) throws Exception {
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
        }
        throw new Exception("Type not found");
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
