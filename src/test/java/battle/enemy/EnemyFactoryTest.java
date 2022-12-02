package battle.enemy;

import objects.battle.Skill;
import objects.battle.SkillType;
import objects.battle.enemy.ai.EnemyPotion;
import objects.battle.enemy.factory.EnemyFactory;
import objects.battle.enemy.EnemyInfo;
import objects.battle.enemy.ai.DefaultAI;
import objects.battle.enemy.ai.SmartAI;
import objects.battle.enemy.gimmick.StatGimmickEntity;
import objects.battle.enemy.gimmick.GimmickType;
import objects.battle.enemy.gimmick.StatGimmickStrategy;
import objects.character.BossFacade;
import objects.character.EnemyFacade;

import objects.character.EnemyFighter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;

public class EnemyFactoryTest {

    @Test
    @DisplayName("This test checks if the EnemyFactory class returns correct enemy")
    public void getEnemyTest() throws Exception {
        Skill skill = new Skill("fireball", 20, 10, SkillType.FIRE);
        ArrayList<Skill> skills = new ArrayList<>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 5, SkillType.FIRE, new EnemyPotion(10));
        DefaultAI enemyAI = new DefaultAI(enemyInfo, 50);
        EnemyFactory enemyFactory = new EnemyFactory();
        EnemyFacade enemy = (EnemyFacade) enemyFactory.createEnemy("goblin");
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
        BossFacade boss = (BossFacade) enemyFactory.createEnemy("goblin warrior");
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
        Assertions.assertTrue(boss.getGimmick() instanceof StatGimmickStrategy);
        Assertions.assertTrue(boss.getEnemyAI() instanceof
                SmartAI);
    }
}
