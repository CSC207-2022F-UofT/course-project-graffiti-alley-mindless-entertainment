package skill;

import battle.entities.Skill;
import battle.entities.SkillType;
import org.junit.Test;

public class SkillTest {
    @Test
    public void skillSetterGetterTest() {
        Skill skill = new Skill("test", 10, 20, SkillType.EARTH);
        assert(skill.getName().equals("test"));
        assert(skill.getLag() == 20);
        assert(skill.getDamage() == 10);
        assert(skill.getType() == SkillType.EARTH);

        skill.setName("testing");
        skill.setDamage(20);
        skill.setLag(30);
        skill.setType(SkillType.FIRE);
        assert(skill.getName().equals("testing"));
        assert(skill.getLag() == 30);
        assert(skill.getDamage() == 20);
        assert(skill.getType() == SkillType.FIRE);
    }
}
