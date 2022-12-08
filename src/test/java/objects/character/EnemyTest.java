package objects.character;

import objects.battle.Skill;
import objects.battle.SkillType;
import objects.battle.enemy.EnemyInfo;
import objects.battle.enemy.ai.DefaultAI;
import objects.battle.enemy.ai.EnemyPotion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class EnemyTest {

    @DisplayName("Test for getHealth method")
    @org.junit.jupiter.api.Test
    public void getHealthTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER, new EnemyPotion(10));
        EnemyFacade enemy = new EnemyFacade("goblin", enemyInfo, new DefaultAI(enemyInfo, 30));
        Assertions.assertEquals(enemy.getHealth(), 100);
    }

    @DisplayName("Test for changeHealth method")
    @org.junit.jupiter.api.Test
    public void changeHealthTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER, new EnemyPotion(10));
        EnemyFacade enemy = new EnemyFacade("goblin", enemyInfo, new DefaultAI(enemyInfo, 30));
        enemy.changeHealth(-10);
        Assertions.assertEquals(enemyInfo.getHealth(), 90);
    }

    @DisplayName("Test for getSpeed method")
    @org.junit.jupiter.api.Test
    public void getSpeedTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER, new EnemyPotion(10));
        EnemyFacade enemy = new EnemyFacade("goblin", enemyInfo, new DefaultAI(enemyInfo, 30));
        Assertions.assertEquals(enemy.getSpeed(), 90);
    }

    @DisplayName("Test for changeSpeed method")
    @org.junit.jupiter.api.Test
    public void changeSpeedTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER, new EnemyPotion(10));
        EnemyFacade enemy = new EnemyFacade("goblin", enemyInfo, new DefaultAI(enemyInfo, 30));
        enemy.changeSpeed(10);
        Assertions.assertEquals(enemy.getSpeed(), 100);
    }

    @DisplayName("Test for checkAlive method")
    @org.junit.jupiter.api.Test
    public void checkDeadTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER, new EnemyPotion(10));
        EnemyFacade enemy = new EnemyFacade("goblin", enemyInfo, new DefaultAI(enemyInfo, 30));
        enemy.setHealth(0);
        Assertions.assertFalse(enemy.checkAlive());
    }

    @DisplayName("Test for checkAlive method when its alive")
    @org.junit.jupiter.api.Test
    public void checkAliveTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER, new EnemyPotion(10));
        EnemyFacade enemy = new EnemyFacade("goblin", enemyInfo, new DefaultAI(enemyInfo, 30));
        enemy.setHealth(10);
        Assertions.assertTrue(enemy.checkAlive());
    }


    @DisplayName("Test for setHealth method")
    @org.junit.jupiter.api.Test
    public void setHealthTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER, new EnemyPotion(10));
        EnemyFacade enemy = new EnemyFacade("goblin", enemyInfo, new DefaultAI(enemyInfo, 30));
        enemy.setHealth(50);
        Assertions.assertEquals(enemy.getHealth(), 50);
    }

    @DisplayName("Test for setSpeed method")
    @org.junit.jupiter.api.Test
    public void setSpeedTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER, new EnemyPotion(10));
        EnemyFacade enemy = new EnemyFacade("goblin", enemyInfo, new DefaultAI(enemyInfo, 30));
        enemy.setSpeed(80);
        Assertions.assertEquals(enemy.getSpeed(), 80);
    }

    @DisplayName("Test for getReputation method")
    @org.junit.jupiter.api.Test
    public void getReputationTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER, new EnemyPotion(10));
        EnemyFacade enemy = new EnemyFacade("goblin", enemyInfo, new DefaultAI(enemyInfo, 30));
        Assertions.assertEquals(enemy.getReputation(), 10);
    }

    @DisplayName("Test for getSkill method")
    @org.junit.jupiter.api.Test
    public void getSkillTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER, new EnemyPotion(10));
        EnemyFacade enemy = new EnemyFacade("goblin", enemyInfo, new DefaultAI(enemyInfo, 30));
        Assertions.assertEquals(enemy.getSkill(0), skill);
    }

    @DisplayName("Test for getSkills method")
    @org.junit.jupiter.api.Test
    public void getSkillsTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER, new EnemyPotion(10));
        EnemyFacade enemy = new EnemyFacade("goblin", enemyInfo, new DefaultAI(enemyInfo, 30));
        Assertions.assertEquals(enemy.getSkills(), skills);
    }

    @DisplayName("Test for getType method")
    @org.junit.jupiter.api.Test
    public void getTypeTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER, new EnemyPotion(10));
        EnemyFacade enemy = new EnemyFacade("goblin", enemyInfo, new DefaultAI(enemyInfo, 30));
        Assertions.assertEquals(enemy.getType(), SkillType.WATER);
    }

    @DisplayName("Test for setType method")
    @org.junit.jupiter.api.Test
    public void setTypeTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER, new EnemyPotion(10));
        EnemyFacade enemy = new EnemyFacade("goblin", enemyInfo, new DefaultAI(enemyInfo, 30));
        enemy.setType(SkillType.FIRE);
        Assertions.assertEquals(enemy.getType(), SkillType.FIRE);
    }

    @DisplayName("Test for getPotion method")
    @Test
    public void getPotionTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER, new EnemyPotion(10));
        EnemyFacade enemy = new EnemyFacade("goblin", enemyInfo, new DefaultAI(enemyInfo, 30));
        enemy.setType(SkillType.FIRE);
        Assertions.assertEquals(10, enemyInfo.getPotion().getHp());
    }
}
