package battle.enemy.ai;

import objects.battle.skills.Skill;
import objects.battle.skills.SkillType;
import objects.battle.enemy.ai.SkillHandler;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class SkillHandlerTest {

    @Test
    public void TypeAdvTest(){
        SkillType air = SkillType.AIR;
        SkillType earth = SkillType.EARTH;
        SkillType fire = SkillType.FIRE;
        SkillType water = SkillType.WATER;
        SkillHandler skillHandler = new SkillHandler();
        Assertions.assertTrue(skillHandler.hasTypeAdv(air, water));
        Assertions.assertTrue(skillHandler.hasTypeAdv(earth, air));
        Assertions.assertTrue(skillHandler.hasTypeAdv(fire, earth));
        Assertions.assertTrue(skillHandler.hasTypeAdv(water, fire));
    }

    @Test
    public void CalculateDamageTest(){
        SkillType air = SkillType.AIR;
        SkillType earth = SkillType.EARTH;
        SkillType water = SkillType.WATER;
        SkillHandler skillHandler = new SkillHandler();
        Skill airSkill = new Skill("skill", 10, 10, air);
        Assertions.assertEquals(skillHandler.calculateDamage(airSkill, water), 12);
        Assertions.assertEquals(skillHandler.calculateDamage(airSkill, earth), 8);
    }
}
