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
        for (i in enemyData.skills) {
            SkillData skillData = databaseManager.fetchSkillData(i);
            int damage = skillData.damage;
            String type = skillData.type;
            Skill skill = new Skill(i, damage, type);
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

    public static Boss createBoss4() {
        Boss boss = new Boss("Boss4", 10);
        Skill skill = Skill.getBeam(); //decide which skill the slime has with charlie
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        Gimmick gimmick = new Gimmick.get
    }


}