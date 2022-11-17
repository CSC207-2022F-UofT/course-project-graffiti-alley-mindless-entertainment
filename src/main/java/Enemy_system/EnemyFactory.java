package Enemy_system;

package Enemy_System;
import objects.character.Boss;
import objects.character.Enemy;
import Enemy_Entities.Gimmick;
import Enemy_system.AttackGimmick;

import managers.DatabaseManager;
import java.util.ArrayList;
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
        EnemyAI enemyType;
        if (enemyData.type == "Passive") {
            enemyType = Enemy_system.PassiveAI;
        } else{
            enemyType = Enemy_system.AggresiveAI;
        }
        Enemy enemy = new Enemy(name, 1, skills, enemyType);
        return enemy;
    }

    public static Boss getBoss(String name){
        BossData bossData = databaseManager.fetchBossData(name);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        for (String i:bossData.skills) {
            SkillData skillData = databaseManager.fetchSkillData(i);
            int damage = skillData.damage;
            String type = skillData.type;
            int lag = skillData.lag;
            Skill skill = new Skill(i, damage, lag, type);
            skills.add(skill);
        }
        EnemyAI bossType;
        if (bossData.type == "Passive") {
            bossType = Enemy_system.PassiveAI;
        } else{
            bossType = Enemy_system.AggresiveAI;
        }

        if(bossData.gimmick == "Health"){
            Gimmick gimmick = new Enemy_system.HealthGimmick();
        } if(bossData.gimmick == "Attack"){
            Gimmick gimmick = new Enemy_system.AttackGimmick();
        } if(bossData.gimmick == "Damage"){
            Gimmick gimmick = new Enemy_system.DamageGimmick();
        } if(bossData.gimmick == "Turn"){
            Gimmick gimmick = new Enemy_system.TurnGimmick();


        Boss boss = new Boss(name, 1, skills, enemyType, gimmick);
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