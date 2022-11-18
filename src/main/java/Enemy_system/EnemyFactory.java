package Enemy_system;

package Enemy_System;
import objects.character.Boss;
import objects.character.Enemy;
import Enemy_Entities.Gimmick;
import Enemy_system.AttackGimmick;

import managers.DatabaseManager;
import java.util.ArrayList;
import java.util.Objects;

import data_objects.EnemyData;
import data_objects.SkillData;

public class EnemyFactory {

    public static Enemy getEnemy(String name){
        EnemyData enemyData = databaseManager.fetchEnemyData(name);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        for (String i:enemyData.skills) {
            SkillData skillData = databaseManager.fetchSkillData(i);
            int damage = skillData.damage;
            String type = skillData.type;
            int lag = skillData.lag;
            Skill skill = new Skill(i, damage, lag, type);
            skills.add(skill);
        }
        int reputation = enemyData.reputation;
        int speed = enemyData.speed;

        String typeStr = enemyData.type;
        switch (typeStr){
            case "water":{
                Type type = new Type.WATER;
                break;
            }
            case "fire":{
                Type type = new Type.FIRE;
                break;
            }
            case "grass":{
                Type type = new Type.GRASS;
                break;
            }
            case "normal":{
                Type type = new Type.NORMAL;
                break;
            }
        }

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

    public static Boss getBoss(String name){
        BossData bossData = databaseManager.fetchEnemyData(name);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        for (String i:bossData.skills) {
            SkillData skillData = databaseManager.fetchSkillData(i);
            int damage = skillData.damage;
            String type = skillData.type;
            int lag = skillData.lag;
            Skill skill = new Skill(i, damage, lag, type);
            skills.add(skill);
        }
        int reputation = bossData.reputation;
        int speed = bossData.speed;
        String typeStr = bossData.type;
        switch (typeStr){
            case "water":{
                Type type = new Type.WATER;
                break;
            }
            case "fire":{
                Type type = new Type.FIRE;
                break;
            }
            case "grass":{
                Type type = new Type.GRASS;
                break;
            }
            case "normal":{
                Type type = new Type.NORMAL;
                break;
            }
        }

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
        switch (gimmick_str) {
            case "Health":{
                Gimmick gimmick = new Enemy_system.HealthGimmick(enemyInfo);
                break;
            }
            case "Attack":{
                Gimmick gimmick = new Enemy_system.AttackGimmick(enemyInfo);
                break;
            }
            case "Damage":{
                Gimmick gimmick = new Enemy_system.DamageGimmick(enemyInfo);
                break;
            }
            case "Turn":{
                Gimmick gimmick = new Enemy_system.TurnGimmick(enemyInfo);
                break;
            }
        }
        Boss boss = new Boss(name, enemyInfo, AItype, gimmick);
        return boss;
    }

    public static Boss createBoss4() {
        Boss boss = new Boss("Boss4", 10);
        Skill skill = Skill.getBeam(); //decide which skill the slime has with charlie
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        Gimmick gimmick = new Gimmick.get
    }


}