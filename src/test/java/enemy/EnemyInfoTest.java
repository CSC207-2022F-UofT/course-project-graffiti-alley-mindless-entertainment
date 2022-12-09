package enemy;

import battle.entities.Skill;
import battle.entities.SkillType;
import battle.entities.EnemyInfo;
import battle.use_cases.ai.DefaultAI;
import battle.entities.EnemyPotion;
import character.EnemyFacade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;

public class EnemyInfoTest {

    @DisplayName("Test for getHealth method")
    @Test
    public void getHealthTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER, new EnemyPotion(10));
        Assertions.assertEquals(enemyInfo.getHealth(), 100);
    }

    @DisplayName("Test for changeHealth method")
    @Test
    public void changeHealthTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER, new EnemyPotion(10));
        enemyInfo.changeHealth(-10);
        Assertions.assertEquals(enemyInfo.getHealth(), 90);
        enemyInfo.changeHealth(200);
        Assertions.assertEquals(enemyInfo.getHealth(), 100);
    }

    @DisplayName("Test for getSpeed method")
    @Test
    public void getSpeedTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER, new EnemyPotion(10));
        Assertions.assertEquals(enemyInfo.getSpeed(), 90);
    }

    @DisplayName("Test for changeSpeed method")
    @Test
    public void changeSpeedTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER, new EnemyPotion(10));
        enemyInfo.changeSpeed(10);
        Assertions.assertEquals(enemyInfo.getSpeed(), 100);
    }

    @DisplayName("Test for checkAlive method")
    @Test
    public void checkAliveTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER, new EnemyPotion(10));
        enemyInfo.setHealth(0);
        Assertions.assertEquals(enemyInfo.checkAlive(), false);
    }

    @DisplayName("Test for setHealth method")
    @Test
    public void setHealthTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER, new EnemyPotion(10));
        enemyInfo.setHealth(50);
        Assertions.assertEquals(enemyInfo.getHealth(), 50);
    }

    @DisplayName("Test for setSpeed method")
    @Test
    public void setSpeedTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER, new EnemyPotion(10));
        enemyInfo.setSpeed(80);
        Assertions.assertEquals(enemyInfo.getSpeed(), 80);
    }

    @DisplayName("Test for getReputation method")
    @Test
    public void getReputationTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER, new EnemyPotion(10));
        Assertions.assertEquals(enemyInfo.getReputation(), 10);
    }

    @DisplayName("Test for getSkill method")
    @Test
    public void getSkillTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER, new EnemyPotion(10));
        Assertions.assertEquals(enemyInfo.getSkill(0), skill);
    }

    @DisplayName("Test for getSkills method")
    @Test
    public void getSkillsTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER, new EnemyPotion(10));
        Assertions.assertEquals(enemyInfo.getSkills(), skills);
    }

    @DisplayName("Test for getType method")
    @Test
    public void getTypeTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER, new EnemyPotion(10));
        Assertions.assertEquals(enemyInfo.getType(), SkillType.WATER);
    }

    @DisplayName("Test for setType method")
    @Test
    public void setTypeTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER, new EnemyPotion(10));
        enemyInfo.setType(SkillType.FIRE);
        Assertions.assertEquals(enemyInfo.getType(), SkillType.FIRE);
    }

    @DisplayName("Test for getPotion method")
    @Test
    public void getPotionTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER, new EnemyPotion(10));
        EnemyFacade enemy = new EnemyFacade("goblin", enemyInfo, new DefaultAI(enemyInfo, 30));
        Assertions.assertEquals(10, enemy.getPotion().getHp());
    }

    @DisplayName("Test for getMaxHealth method")
    @Test
    public void getMaxHealthTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER, new EnemyPotion(10));
        Assertions.assertEquals(100, enemyInfo.getMaxHealth());
    }
}
