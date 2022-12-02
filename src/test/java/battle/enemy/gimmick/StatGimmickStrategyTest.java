package battle.enemy.gimmick;

import objects.battle.Skill;
import objects.battle.SkillType;
import objects.battle.enemy.EnemyInfo;
import objects.battle.enemy.ai.EnemyPotion;
import objects.battle.enemy.factory.EnemyFactory;
import objects.battle.enemy.gimmick.*;
import objects.character.BossFacade;
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
        String text = usecase.useGimmick();
        Assertions.assertEquals(enemyInfo.getHealth(), 100);
        Assertions.assertEquals("!?!?!? Something is happening to the boss! It feels different! The gimmick is triggered! Now the " +
                "boss's health is fully healed!", text);


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
        String text = usecase.useGimmick();
        Assertions.assertEquals(enemyInfo.getSkill(0).getDamage(), 24);
        Assertions.assertEquals("!?!?!? Something is happening to the boss! It feels different! The gimmick is triggered! Now the " +
                "damage of skills increased by 1.2!", text);
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
        String text = usecase.useGimmick();
        Assertions.assertEquals(enemyInfo.getType(), SkillType.FIRE);
        Assertions.assertEquals("!?!?!? Something is happening to the boss! It feels different! The gimmick is triggered! Now the " +
                "boss's type changed to fire!", text);
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
        String text = usecase.useGimmick();
        Assertions.assertEquals(enemyInfo.getSpeed(), 120);
        Assertions.assertEquals("!?!?!? Something is happening to the boss! It feels different! The gimmick is triggered! Now the " +
                "boss's speed increased by 20!", text);
    }

    @DisplayName("Test if the speed gimmick works properly")
    @Test
    public void UseGimmickTest(){
        EnemyFactory enemyFactory = new EnemyFactory();
        BossFacade boss = enemyFactory.createBoss("goblin warrior");
        boss.changeHealth(-90);
        boss.applyGimmick();
        Assertions.assertEquals(100, boss.getHealth());
        boss.changeHealth(-90);
        boolean reuse = boss.applyGimmick();
        Assertions.assertFalse(reuse);
    }
}