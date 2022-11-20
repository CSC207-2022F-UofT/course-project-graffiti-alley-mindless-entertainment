package battle.enemy;

import objects.battle.Skill;
import objects.battle.SkillType;
import objects.battle.enemy.EnemyFactory;
import objects.battle.enemy.EnemyInfo;
import objects.battle.enemy.ai.DefaultAI;
import objects.battle.enemy.ai.EnemyAI;
import objects.battle.enemy.ai.SmartAI;
import objects.battle.enemy.gimmick.HealthGimmick;
import objects.character.Boss;
import objects.character.Enemy;
import org.junit.Assert;
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
        Enemy enemy = new Enemy("goblin", enemyInfo, new DefaultAI(enemyInfo, 50));
        Assert.assertEquals(EnemyFactory.getEnemy("goblin").equals(enemy), true);
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
        Assertions.assertEquals(EnemyFactory.getEnemy("goblin warrior"), boss);
    }
}
//