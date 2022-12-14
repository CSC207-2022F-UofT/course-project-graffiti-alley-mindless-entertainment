package enemy;

import battle.entities.Skill;
import battle.entities.SkillType;
import battle.entities.EnemyPotion;
import battle.factories.EnemyFactory;
import battle.entities.EnemyInfo;
import battle.use_cases.ai.DefaultAI;
import battle.use_cases.ai.SmartAI;
import battle.entities.gimmick.StatGimmickEntity;
import battle.entities.gimmick.GimmickType;

import character.EnemyFighter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;

public class EnemyFactoryTest {

    @Test
    @DisplayName("This test checks if the EnemyFactory class returns correct enemy")
    public void getEnemyTest(){
        Skill skill = new Skill("fireball", 20, 10, SkillType.FIRE);
        ArrayList<Skill> skills = new ArrayList<>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 5, SkillType.FIRE, new EnemyPotion(10));
        DefaultAI enemyAI = new DefaultAI(enemyInfo, 50);
        EnemyFactory enemyFactory = new EnemyFactory();
        EnemyFighter enemy = enemyFactory.createEnemy("goblin");
        Assertions.assertEquals(enemy.getSkill(0).getDamage(), 20);
        Assertions.assertEquals(enemy.getSkill(0).getType(), SkillType.FIRE);
        Assertions.assertEquals(enemy.getSkill(0).getLag(), 10);
        Assertions.assertEquals(enemy.getSkill(0).getName(),
                "fireball");
        Assertions.assertEquals(enemy.getReputation(), 5);
        Assertions.assertEquals(enemy.getSpeed(), 90);
        Assertions.assertEquals(enemy.getType(), SkillType.FIRE);
        Assertions.assertEquals(enemy.getHealth(), 100);
        Assertions.assertEquals(enemy.getName(), "goblin");
        Assertions.assertTrue(enemy.getEnemyAI() instanceof DefaultAI);
    }

    @Test
    @DisplayName("This test checks if the EnemyFactory class returns correct enemy")
    public void getEnemySlimeTest() {
        EnemyFactory enemyFactory = new EnemyFactory();
        EnemyFighter enemy = enemyFactory.createEnemy("slime");
        Assertions.assertEquals(enemy.getSkill(0).getDamage(), 20);
        Assertions.assertEquals(enemy.getSkill(0).getType(), SkillType.WATER);
        Assertions.assertEquals(enemy.getSkill(0).getLag(), 10);
        Assertions.assertEquals(enemy.getSkill(0).getName(),
                "waterfall");
        Assertions.assertEquals(enemy.getReputation(), 5);
        Assertions.assertEquals(enemy.getSpeed(), 90);
        Assertions.assertEquals(enemy.getType(), SkillType.WATER);
        Assertions.assertEquals(enemy.getHealth(), 100);
        Assertions.assertEquals(enemy.getName(), "slime");
        Assertions.assertTrue(enemy.getEnemyAI() instanceof DefaultAI);
    }

    @Test
    @DisplayName("This test checks if the EnemyFactory class returns correct enemy")
    public void getEnemySkeletonTest() {
        EnemyFactory enemyFactory = new EnemyFactory();
        EnemyFighter enemy = enemyFactory.createEnemy("skeleton");
        Assertions.assertEquals(enemy.getSkill(0).getDamage(), 20);
        Assertions.assertEquals(enemy.getSkill(0).getType(), SkillType.AIR);
        Assertions.assertEquals(enemy.getSkill(0).getLag(), 10);
        Assertions.assertEquals(enemy.getSkill(0).getName(),
                "air cutter");
        Assertions.assertEquals(enemy.getReputation(), 5);
        Assertions.assertEquals(enemy.getSpeed(), 90);
        Assertions.assertEquals(enemy.getType(), SkillType.AIR);
        Assertions.assertEquals(enemy.getHealth(), 100);
        Assertions.assertEquals(enemy.getName(), "skeleton");
        Assertions.assertTrue(enemy.getEnemyAI() instanceof DefaultAI);
    }

    @Test
    @DisplayName("This test checks if the EnemyFactory class returns correct enemy")
    public void getEnemyGrassHopperTest() {
        EnemyFactory enemyFactory = new EnemyFactory();
        EnemyFighter enemy = enemyFactory.createEnemy("grass hopper");
        Assertions.assertEquals(enemy.getSkill(0).getDamage(), 20);
        Assertions.assertEquals(enemy.getSkill(0).getType(), SkillType.EARTH);
        Assertions.assertEquals(enemy.getSkill(0).getLag(), 10);
        Assertions.assertEquals(enemy.getSkill(0).getName(),
                "energy ball");
        Assertions.assertEquals(enemy.getReputation(), 5);
        Assertions.assertEquals(enemy.getSpeed(), 90);
        Assertions.assertEquals(enemy.getType(), SkillType.EARTH);
        Assertions.assertEquals(enemy.getHealth(), 100);
        Assertions.assertEquals(enemy.getName(), "grass hopper");
        Assertions.assertTrue(enemy.getEnemyAI() instanceof DefaultAI);
    }

    @Test
    @DisplayName("This test checks if the EnemyFactory class returns correct boss")
    public void getBossTest(){
        Skill skill = new Skill("beam", 25, 10, SkillType.EARTH);
        ArrayList<Skill> skills = new ArrayList<>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 110, 20, SkillType.EARTH, new EnemyPotion(20));
        SmartAI enemyAI = new SmartAI(enemyInfo, 80);
        StatGimmickEntity gimmick = new StatGimmickEntity.StatGimmickBuilder(GimmickType.HEALTH, enemyInfo,
                30).build();
        EnemyFactory enemyFactory = new EnemyFactory();
        EnemyFighter boss = enemyFactory.createEnemy("goblin warrior");
        Assertions.assertEquals(boss.getSkill(0).getDamage(), 25);
        Assertions.assertEquals(boss.getSkill(0).getType(), SkillType.EARTH);
        Assertions.assertEquals(boss.getSkill(0).getLag(), 10);
        Assertions.assertEquals(boss.getSkill(0).getName(),
                "beam");
        Assertions.assertEquals(boss.getReputation(), 20);
        Assertions.assertEquals(boss.getSpeed(), 110);
        Assertions.assertEquals(boss.getType(), SkillType.EARTH);
        Assertions.assertEquals(boss.getHealth(), 100);
        Assertions.assertEquals(boss.getName(), "goblin warrior");
        Assertions.assertTrue(boss.getEnemyAI() instanceof
                SmartAI);
    }

    @Test
    @DisplayName("This test checks if the EnemyFactory class returns correct boss")
    public void getBossKingSlimeTest(){
        EnemyFactory enemyFactory = new EnemyFactory();
        EnemyFighter boss = enemyFactory.createEnemy("slime king");
        Assertions.assertEquals(boss.getSkill(0).getDamage(), 25);
        Assertions.assertEquals(boss.getSkill(0).getType(), SkillType.WATER);
        Assertions.assertEquals(boss.getSkill(0).getLag(), 10);
        Assertions.assertEquals(boss.getSkill(0).getName(),
                "water punch");
        Assertions.assertEquals(boss.getReputation(), 20);
        Assertions.assertEquals(boss.getSpeed(), 110);
        Assertions.assertEquals(boss.getType(), SkillType.WATER);
        Assertions.assertEquals(boss.getHealth(), 100);
        Assertions.assertEquals(boss.getName(), "slime king");
        Assertions.assertTrue(boss.getEnemyAI() instanceof
                SmartAI);
    }

    @Test
    @DisplayName("This test checks if the EnemyFactory class returns correct boss")
    public void getBossSkeletonKingTest(){
        EnemyFactory enemyFactory = new EnemyFactory();
        EnemyFighter boss = enemyFactory.createEnemy("skeleton king");
        Assertions.assertEquals(boss.getSkill(0).getDamage(), 25);
        Assertions.assertEquals(boss.getSkill(0).getType(), SkillType.AIR);
        Assertions.assertEquals(boss.getSkill(0).getLag(), 10);
        Assertions.assertEquals(boss.getSkill(0).getName(),
                "air punch");
        Assertions.assertEquals(boss.getReputation(), 20);
        Assertions.assertEquals(boss.getSpeed(), 110);
        Assertions.assertEquals(boss.getType(), SkillType.AIR);
        Assertions.assertEquals(boss.getHealth(), 100);
        Assertions.assertEquals(boss.getName(), "skeleton king");
        Assertions.assertTrue(boss.getEnemyAI() instanceof
                SmartAI);
    }

    @Test
    @DisplayName("This test checks if the EnemyFactory class returns correct boss")
    public void getBossKingWizardTest(){
        EnemyFactory enemyFactory = new EnemyFactory();
        EnemyFighter boss = enemyFactory.createEnemy("king wizard");
        Assertions.assertEquals(boss.getSkill(0).getDamage(), 25);
        Assertions.assertEquals(boss.getSkill(0).getType(), SkillType.FIRE);
        Assertions.assertEquals(boss.getSkill(0).getLag(), 10);
        Assertions.assertEquals(boss.getSkill(0).getName(),
                "fire punch");
        Assertions.assertEquals(boss.getReputation(), 20);
        Assertions.assertEquals(boss.getSpeed(), 110);
        Assertions.assertEquals(boss.getType(), SkillType.FIRE);
        Assertions.assertEquals(boss.getHealth(), 100);
        Assertions.assertEquals(boss.getName(), "king wizard");
        Assertions.assertTrue(boss.getEnemyAI() instanceof
                SmartAI);
    }
}
