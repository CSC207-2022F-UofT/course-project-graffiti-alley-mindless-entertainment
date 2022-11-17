package Enemy_system;

package Enemy_System;
import objects.character.Boss;
import objects.character.Enemy;
import Enemy_Entities.Gimmick;
import Enemy_system.AttackGimmick;

import managers.DatabaseManager;
import java.util.ArrayList;
import data_objects.EnemyData;

public class EnemyFactory {

    public static Enemy getEnemy1(int zone, boolean isboss){
        if(zone==1 && !isboss){
            return getSlime();
        } if(zone==2 && !isboss){
            return getGoblin();
        } if(zone==3 && !isboss){
            return getSkeleton();
        } if(zone==4 && !isboss){
            return getSoldier();
        } if(zone==1 && isboss){
            return createBoss1();
        } if(zone==2 && isboss){
            return createBoss2();
        } if(zone==3 && isboss){
            return createBoss3();
        } else {
            return createBoss4();
        }
    }

    public static Enemy getEnemy(String name){
        EnemyData enemyData = databaseManager.fetchEnemyData(name);
        Enemy enemy = new Enemy(name, 1, Enemy_system.AgressiveAI);
        Skill skill = Skill.getFireball(); //since it is static method????
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        enemy.set_skills(skills);
        return enemy;

    }

    public static Enemy getGoblin(){
        Enemy enemy = new Enemy("Goblin", 1);
        Skill skill = Skill.getFireball(); //since it is static method????
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        enemy.set_skills(skills);
        return enemy;
    }

    public static Enemy getSlime(){
        Enemy enemy = new Enemy("Slime", 1);
        Skill skill = Skill.getWaterfall(); //decide which skill the slime has with charlie
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        enemy.set_skills(skills);
        return enemy;
    }

    public static Enemy getSkeleton(){
        Enemy enemy = new Enemy("Skeleton", 1);
        Skill skill = Skill.getPunch(); //decide which skill the slime has with charlie
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        enemy.set_skills(skills);
        return enemy;
    }

    public static Enemy getSoldier() {
        Enemy enemy = new Enemy("Soldier", 1);
        Skill skill = Skill.getShoot(); //decide which skill the slime has with charlie
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        enemy.set_skills(skills);
        return enemy;
    }

    public static Boss createBoss1() {
        Boss boss = new Boss("Boss1", 10);
        Skill skill = Skill.getBeam(); //decide which skill the slime has with charlie
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        Gimmick gimmick = new HealthGimmick();
        boss.setGimmick(gimmick);
        return boss;
    }

    public static Boss createBoss2() {
        Boss boss = new Boss("Boss2", 10);
        Skill skill = Skill.getBeam(); //decide which skill the slime has with charlie
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        Gimmick gimmick = new AttackGimmick();
        boss.setGimmick(gimmick);
        return boss;
    }

    public static Boss createBoss3() {
        Boss boss = new Boss("Boss3", 10);
        Skill skill = Skill.getBeam(); //decide which skill the slime has with charlie
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        Gimmick gimmick = new TurnGimmick();
        boss.setGimmick(gimmick);
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