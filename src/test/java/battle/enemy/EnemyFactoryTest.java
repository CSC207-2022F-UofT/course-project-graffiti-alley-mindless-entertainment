package battle.enemy;

import objects.battle.Skill;
import objects.battle.SkillType;
import objects.battle.enemy.EnemyFactory;
import objects.battle.enemy.EnemyInfo;
import objects.battle.enemy.ai.DefaultAI;
import objects.battle.enemy.ai.SmartAI;
import objects.battle.enemy.gimmick.HealthGimmick;
import objects.character.Boss;
import objects.character.Enemy;

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
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 5, SkillType.FIRE);
        DefaultAI enemyAI = new DefaultAI(enemyInfo, 50);
        Enemy enemy = new Enemy("goblin", enemyInfo, enemyAI);
        Assertions.assertEquals(EnemyFactory.getEnemy("goblin").getSkill(0).getDamage(), 20);
        Assertions.assertEquals(EnemyFactory.getEnemy("goblin").getSkill(0).getType(), SkillType.FIRE);
        Assertions.assertEquals(EnemyFactory.getEnemy("goblin").getSkill(0).getLag(), 10);
        Assertions.assertEquals(EnemyFactory.getEnemy("goblin").getSkill(0).getName(),
                "fireball");
        Assertions.assertEquals(EnemyFactory.getEnemy("goblin").getReputation(), 5);
        Assertions.assertEquals(EnemyFactory.getEnemy("goblin").getSpeed(), 90);
        Assertions.assertEquals(EnemyFactory.getEnemy("goblin").getType(), SkillType.FIRE);
        Assertions.assertEquals(EnemyFactory.getEnemy("goblin").getHealth(), 100);
        Assertions.assertEquals(EnemyFactory.getEnemy("goblin").getName(), "goblin");
        Assertions.assertEquals(EnemyFactory.getEnemy("goblin").getEnemyAI() instanceof DefaultAI, true);
    }

    @Test
    @DisplayName("This test checks if the EnemyFactory class returns correct boss")
    public void getBossTest(){
        Skill skill = new Skill("beam", 25, 10, SkillType.EARTH);
        ArrayList<Skill> skills = new ArrayList<>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 110, 20, SkillType.EARTH);
        SmartAI enemyAI = new SmartAI(enemyInfo, 80);
        HealthGimmick gimmick = new HealthGimmick(enemyInfo);
        Boss boss = new Boss("goblin warrior", enemyInfo, enemyAI, gimmick);
        Assertions.assertEquals(EnemyFactory.getBoss("goblin warrior").getSkill(0).getDamage(), 25);
        Assertions.assertEquals(EnemyFactory.getBoss("goblin warrior").getSkill(0).getType(), SkillType.EARTH);
        Assertions.assertEquals(EnemyFactory.getBoss("goblin warrior").getSkill(0).getLag(), 10);
        Assertions.assertEquals(EnemyFactory.getBoss("goblin warrior").getSkill(0).getName(),
                "beam");
        Assertions.assertEquals(EnemyFactory.getBoss("goblin warrior").getReputation(), 20);
        Assertions.assertEquals(EnemyFactory.getBoss("goblin warrior").getSpeed(), 110);
        Assertions.assertEquals(EnemyFactory.getBoss("goblin warrior").getType(), SkillType.EARTH);
        Assertions.assertEquals(EnemyFactory.getBoss("goblin warrior").getHealth(), 100);
        Assertions.assertEquals(EnemyFactory.getBoss("goblin warrior").getName(), "goblin warrior");
        Assertions.assertEquals(EnemyFactory.getBoss("goblin warrior").getGimmick() instanceof
                HealthGimmick, true);
        Assertions.assertEquals(EnemyFactory.getBoss("goblin warrior").getEnemyAI() instanceof
                SmartAI, true);
    }
}
