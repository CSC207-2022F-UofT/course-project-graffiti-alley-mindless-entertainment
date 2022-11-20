package battle.enemy;

import objects.battle.Skill;
import objects.battle.SkillType;
import objects.battle.enemy.EnemyInfo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import objects.character.Enemy;
import objects.character.Boss;
import battle.*;

import java.util.ArrayList;

public class EnemyInfoTest {

    @DisplayName("Test for getHealth method")
    @Test
    public void getHealthTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER);
        Assert.assertEquals(enemyInfo.getHealth(), 100);
    }

    @DisplayName("Test for changeHealth method")
    @Test
    public void changeHealthTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER);
        enemyInfo.changeHealth(-10);
        Assert.assertEquals(enemyInfo.getHealth(), 90);
    }

    @DisplayName("Test for getSpeed method")
    @Test
    public void getSpeedTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER);
        Assert.assertEquals(enemyInfo.getSpeed(), 90);
    }

    @DisplayName("Test for changeSpeed method")
    @Test
    public void changeSpeedTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER);
        enemyInfo.changeSpeed(10);
        Assert.assertEquals(enemyInfo.getSpeed(), 100);
    }

    @DisplayName("Test for checkAlive method")
    @Test
    public void checkAliveTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER);
        enemyInfo.setHealth(0);
        Assert.assertEquals(enemyInfo.checkAlive(), false);
    }

    @DisplayName("Test for setHealth method")
    @Test
    public void setHealthTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER);
        enemyInfo.setHealth(50);
        Assert.assertEquals(enemyInfo.getHealth(), 50);
    }

    @DisplayName("Test for setSpeed method")
    @Test
    public void setSpeedTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER);
        enemyInfo.setSpeed(80);
        Assert.assertEquals(enemyInfo.getSpeed(), 80);
    }

    @DisplayName("Test for getReputation method")
    @Test
    public void getReputationTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER);
        Assert.assertEquals(enemyInfo.getReputation(), 10);
    }

    @DisplayName("Test for getSkill method")
    @Test
    public void getSkillTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER);
        Assert.assertEquals(enemyInfo.getSkill(0), skill);
    }

    @DisplayName("Test for getSkills method")
    @Test
    public void getSkillsTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER);
        Assert.assertEquals(enemyInfo.getSkills(), skills);
    }

    @DisplayName("Test for getType method")
    @Test
    public void getTypeTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER);
        Assert.assertEquals(enemyInfo.getType(), SkillType.WATER);
    }

    @DisplayName("Test for setType method")
    @Test
    public void setTypeTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER);
        enemyInfo.setType(SkillType.FIRE);
        Assert.assertEquals(enemyInfo.getType(), SkillType.FIRE);
    }

}
