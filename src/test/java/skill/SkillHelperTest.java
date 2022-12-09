package skill;

import battle.entities.Skill;
import battle.use_cases.SkillHelper;
import battle.entities.SkillType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SkillHelperTest {
    @Test
    public void toSkillString() {
        SkillHelper skillHelper = new SkillHelper();
        List<Skill> skillList = new ArrayList<>();
        List<String> testList = new ArrayList<>();
        testList.add("test1");
        testList.add("test2");
        testList.add("test3");
        skillList.add(new Skill("test1", 0, 0, SkillType.FIRE));
        skillList.add(new Skill("test2", 0, 0, SkillType.FIRE));
        skillList.add(new Skill("test3", 0, 0, SkillType.FIRE));
        List<String> gotList = skillHelper.toSkillString(skillList);
        assert(gotList.get(0).equals(testList.get(0)));
        assert(gotList.get(1).equals(testList.get(1)));
        assert(gotList.get(2).equals(testList.get(2)));
    }
}
