package battle.enemy.ai;


import objects.battle.Skill;
import objects.battle.SkillType;
import objects.battle.enemy.EnemyInfo;
import objects.battle.enemy.ai.DefaultAI;
import objects.battle.enemy.ai.EnemyAction;
import objects.battle.enemy.ai.EnemyPotion;
import objects.battle.enemy.ai.SmartAI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


import java.util.ArrayList;

public class EnemyAITest {

    @DisplayName("Test of Default AI with 100% attack chance")
    @Test
    public void DefaultAIRespondTest1(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER);
        DefaultAI defaultAI = new DefaultAI(enemyInfo, 100);
        EnemyAction enemyAction = defaultAI.respond("use skill");
        Assertions.assertTrue(enemyAction instanceof Skill);

    }
    @DisplayName("Test of Default AI with 0% attack chance")
    @Test
    public void DefaultAIRespondTest2(){
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 10, SkillType.WATER);
        DefaultAI defaultAI = new DefaultAI(enemyInfo, 0);
        Assertions.assertTrue(defaultAI.respond("use skill") instanceof EnemyPotion);
    }

    @DisplayName("Test of Default AI with 50% attack chance")
    @Test
    public void DefaultAIRespondTest() {
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 0, SkillType.WATER);
        DefaultAI defaultAI = new DefaultAI(enemyInfo, 50);
        EnemyAction respond = defaultAI.respond("use skill");
        Boolean check = respond instanceof Skill;
        Boolean check2 = respond instanceof EnemyPotion;
        Assertions.assertTrue(check||check2);
    }

    @DisplayName("Test of SmartAI with 50% attack chance")
    @Test
    public void SmartAIRespondTest() {
        Skill skill = new Skill("fire ball", 20, 5, SkillType.WATER);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(skill);
        EnemyInfo enemyInfo = new EnemyInfo(skills, 90, 0, SkillType.WATER);
        SmartAI smartAI = new SmartAI(enemyInfo, 50);
        EnemyAction respond = smartAI.respond("use skill");
        Boolean check = respond instanceof Skill;
        Boolean check2 = respond instanceof EnemyPotion;
        Assertions.assertTrue(check||check2);
    }
}
