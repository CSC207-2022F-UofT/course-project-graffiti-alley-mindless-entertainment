package enemy.gimmick;

import battle.entities.gimmick.GimmickType;
import battle.entities.gimmick.StatGimmickEntity;
import battle.use_cases.gimmick.StatGimmickStrategy;
import battle.entities.Skill;
import battle.entities.SkillType;
import battle.entities.EnemyInfo;
import battle.entities.EnemyPotion;
import battle.factories.EnemyFactory;
import character.EnemyFighter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


import java.util.ArrayList;

public class StatGimmickStrategyTest {

    @DisplayName("Test if the health gimmick works properly")
    @Test
    public void UseHealthGimmickTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER, new EnemyPotion(10));
        enemyInfo.changeHealth(-90);
        StatGimmickEntity gimmick = new StatGimmickEntity.StatGimmickBuilder(GimmickType.HEALTH, enemyInfo,
                30).build();
        StatGimmickStrategy usecase = new StatGimmickStrategy(gimmick);
        usecase.useGimmick();
        Assertions.assertEquals(enemyInfo.getHealth(), 100);



    }

    @DisplayName("Test if the attack gimmick works properly")
    @Test
    public void UseAttackGimmickTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER, new EnemyPotion(10));
        enemyInfo.changeHealth(-90);
        StatGimmickEntity gimmick = new StatGimmickEntity.StatGimmickBuilder(GimmickType.ATTACK, enemyInfo,
                20).setAttackIncrease(1.2).build();
        StatGimmickStrategy usecase = new StatGimmickStrategy(gimmick);
        usecase.useGimmick();
        Assertions.assertEquals(enemyInfo.getSkill(0).getDamage(), 24);

    }

    @DisplayName("Test if the type gimmick works properly")
    @Test
    public void UseTypeGimmickTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER, new EnemyPotion(10));
        enemyInfo.changeHealth(-90);
        StatGimmickEntity gimmick = new StatGimmickEntity.StatGimmickBuilder(GimmickType.TYPE, enemyInfo,
                20).setNewType(SkillType.FIRE).build();
        StatGimmickStrategy usecase = new StatGimmickStrategy(gimmick);
        usecase.useGimmick();
        Assertions.assertEquals(enemyInfo.getType(), SkillType.FIRE);
    }

    @DisplayName("Test if the speed gimmick works properly")
    @Test
    public void UseSpeedGimmickTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 100, 10, SkillType.WATER, new EnemyPotion(10));
        enemyInfo.changeHealth(-90);
        StatGimmickEntity gimmick = new StatGimmickEntity.StatGimmickBuilder(GimmickType.SPEED, enemyInfo,
                25).setSpeedIncrease(20).build();
        StatGimmickStrategy usecase = new StatGimmickStrategy(gimmick);
        usecase.useGimmick();
        Assertions.assertEquals(enemyInfo.getSpeed(), 120);

    }

    @DisplayName("Test if the speed gimmick works properly")
    @Test
    public void UseGimmickTest(){
        EnemyFactory enemyFactory = new EnemyFactory();
        EnemyFighter boss = enemyFactory.createEnemy("goblin warrior");
        boss.changeHealth(-90);
        boss.applyGimmick();
        Assertions.assertEquals(100, boss.getHealth());
        boss.changeHealth(-90);
        boss.applyGimmick();
        Assertions.assertNotEquals(100, boss.getHealth());

    }
}