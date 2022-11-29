package battle.enemy.gimmick;

import objects.battle.Skill;
import objects.battle.SkillType;
import objects.battle.enemy.EnemyInfo;
import objects.battle.enemy.gimmick.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


        import java.util.ArrayList;

public class GimmickTest {

    @DisplayName("Test if the health gimmick works properly")
    @Test
    public void UseHealthGimmickTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER);
        HealthGimmick gimmick = new HealthGimmick(enemyInfo, 30);
        UseGimmick usecase = new UseHealthGimmick(gimmick);
        usecase.useGimmick();
        Assert.assertEquals(enemyInfo.getHealth(), 100);
    }

    @DisplayName("Test if the attack gimmick works properly")
    @Test
    public void UseAttackGimmickTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER);
        AttackGimmick gimmick = new AttackGimmick(enemyInfo, 20, 1.2);
        UseGimmick usecase =  new UseAttackGimmick(gimmick);
        usecase.useGimmick();
        Assert.assertEquals(enemyInfo.getSkill(0).getDamage(), 24);
    }

    @DisplayName("Test if the type gimmick works properly")
    @Test
    public void UseTypeGimmickTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER);
        TypeGimmick gimmick = new TypeGimmick(enemyInfo, 20);
        UseGimmick usecase = new UseTypeGimmick(gimmick);
        usecase.useGimmick();
        Assert.assertEquals(enemyInfo.getType(), SkillType.FIRE);
    }

    @DisplayName("Test if the speed gimmick works properly")
    @Test
    public void UseSpeedGimmickTest(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 100, 10, SkillType.WATER);
        SpeedGimmick gimmick = new SpeedGimmick(enemyInfo, 25, 20);
        UseGimmick usecase = new UseSpeedGimmick(gimmick);
        usecase.useGimmick();
        Assert.assertEquals(enemyInfo.getSpeed(), 120);
    }
}