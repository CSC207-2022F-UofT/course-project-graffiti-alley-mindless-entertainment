package battle.enemy.gimmick;

import battle.enemy.ai;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import objects.character.Enemy;
import battle.Skill;

        import java.util.ArrayList;

public class EnemyAITest {

    @DisplayName("Test if the health gimmick works properly")
    @Test
    public void UseHealthGimmickTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER);
        Gimmick gimmick = new HealthGimmick(enemyInfo);
        gimmick.useGimmick();
        Assert.assertEquals(enemyInfo.getHealth, 100);
    }

    @DisplayName("Test if the attack gimmick works properly")
    @Test
    public void UseAttackGimmickTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER);
        Gimmick gimmick = new HealthGimmick(enemyInfo);
        gimmick.useGimmick();
        Assert.assertEquals(enemyInfo.getSkill(0).getDamage, 24);
    }

    @DisplayName("Test if the type gimmick works properly")
    @Test
    public void UseTypeGimmickTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER);
        Gimmick gimmick = new TypeGimmick(enemyInfo);
        gimmick.useGimmick();
        Assert.assertEquals(enemyInfo.getType(), SkillType.FIRE);
    }

    @DisplayName("Test if the speed gimmick works properly")
    @Test
    public void UseSpeedGimmickTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 100, 10, SkillType.WATER);
        Gimmick gimmick = new SpeedGimmick(enemyInfo);
        gimmick.useGimmick();
        Assert.assertEquals(enemyInfo.getSpeed(), 150);
    }
}