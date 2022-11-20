package objects.character;

import objects.battle.Skill;
import objects.battle.SkillType;
import org.junit.jupiter.api.Test;

import java.util.Objects;

class PlayerTest {

    @Test
    void getNameEmpty() {
        Player player = new Player("", null);
        assert(Objects.equals(player.getName(), ""));
    }

    @Test
    void getNameString() {
        Player player = new Player("abc", null);
        assert(Objects.equals(player.getName(), "abc"));
    }

    @Test
    void changeNameEmpty() {
        Player player = new Player("", null);
        player.changeName("abc");
        assert(Objects.equals(player.getName(), "abc"));
    }

    @Test
    void changeNameSame() {
        Player player = new Player("a", null);
        player.changeName("a");
        assert(Objects.equals(player.getName(), "a"));
    }

    @Test
    void getDescriptionEmpty() {
        Player player = new Player("a", null);
        assert(Objects.equals(player.getDescription(), ""));
    }

    @Test
    void changeDescription() {
        Player player = new Player("a", null);
        player.changeDescription("1234");
        assert(Objects.equals(player.getDescription(), "1234"));
    }

    @Test
    void getCurrHealthUnchanged() {
        Player player = new Player("a", null);
        assert(player.getCurrHealth() == 100);
    }

    @Test
    void changeCurrHealthAboveZero() {
        Player player = new Player("a", null);
        player.changeCurrHealth(-50);
        assert(player.getCurrHealth() == 50);
    }

    @Test
    void changeCurrHealthToZero() {
        Player player = new Player("a", null);
        player.changeCurrHealth(-100);
        assert(player.getCurrHealth() == 0);
    }

    @Test
    void changeCurrHealthBelowZero() {
        Player player = new Player("a", null);
        player.changeCurrHealth(200);
        assert(player.getCurrHealth() == 0);
    }

    @Test
    void changeCurrHealthAboveMax() {
        Player player = new Player("a", null);
        player.changeCurrHealth(100);
        assert(player.getCurrHealth() == 100);
    }

    @Test
    void getMaxHealth() {
        Player player = new Player("a", null);
        assert(player.getMaxHealth() == 100);
    }

    @Test
    void changeMaxHealthIncrease() {
        Player player = new Player("a", null);
        player.changeMaxHealth(100);
        assert(player.getMaxHealth() == 200);
    }

    @Test
    void changeMaxHealthDecrease() {
        Player player = new Player("a", null);
        player.changeMaxHealth(200);
        assert(player.getMaxHealth() == 1);
    }

    @Test
    void getArmor() {
        Player player = new Player("a", null);
        assert(player.getArmor() == 0);
    }

    @Test
    void changeArmorIncrease() {
        Player player = new Player("a", null);
        player.changeArmor(100);
        assert(player.getArmor() == 100);
    }

    @Test
    void changeArmorDecrease() {
        Player player = new Player("a", null);
        player.changeArmor(100);
        player.changeArmor(-200);
        assert(player.getArmor() == 0);
    }

    @Test
    void getExperience() {
        Player player = new Player("a", null);
        assert(player.getExperience() == 0);
    }

    @Test
    void changeExperienceIncrease() {
        Player player = new Player("a", null);
        player.changeExperience(100);
        assert(player.getExperience() == 100);
    }

    @Test
    void changeExperienceDecrease() {
        Player player = new Player("a", null);
        player.changeExperience(100);
        player.changeExperience(-200);
        assert(player.getExperience() == 0);
    }

    @Test
    void getLevel() {
        Player player = new Player("a", null);
        assert(player.getLevel() == 0);
    }

    @Test
    void changeLevelIncrease() {
        Player player = new Player("a", null);
        player.changeLevel(100);
        assert(player.getLevel() == 100);
    }

    @Test
    void changeLevelDecrease() {
        Player player = new Player("a", null);
        player.changeLevel(100);
        player.changeLevel(-200);
        assert(player.getLevel() == 0);
    }

    @Test
    void getSkillType() {
        Player player = new Player("a", SkillType.AIR);
        assert(player.getSkillType() == SkillType.AIR);
    }

    @Test
    void changeSkillType() {
        Player player = new Player("a", SkillType.AIR);
        player.changeSkillType(SkillType.FIRE);
        assert(player.getSkillType() == SkillType.FIRE);
    }

    @Test
    void getSpeed() {
        Player player = new Player("a", null);
        assert(player.getSpeed() == 100);
    }

    @Test
    void changeSpeedIncrease() {
        Player player = new Player("a", null);
        player.changeSpeed(100);
        assert(player.getSpeed() == 200);
    }

    @Test
    void changeSpeedDecrease() {
        Player player = new Player("a", null);
        player.changeSpeed(-200);
        assert(player.getSpeed() == -100);
    }

    @Test
    void getMoney() {
        Player player = new Player("a", null);
        assert(player.getMoney() == 20);
    }

    @Test
    void changeMoneyIncrease() {
        Player player = new Player("a", null);
        player.changeMoney(100);
        assert(player.getMoney() == 120);
    }

    @Test
    void changeMoneyDecrease() {
        Player player = new Player("a", null);
        player.changeMoney(-120);
        assert(player.getMoney() == -100);
    }

    @Test
    void getSkillsList() {
        Player player = new Player("a", null);
        assert(player.getSkillList().isEmpty());
    }

    @Test
    void addSkillEmpty() {
        Player player = new Player("a", null);
        Skill a = new Skill("a", 1, 1, null);
        player.addSkill(a);
        assert(player.getSkillList().contains(a));
    }

    @Test
    void addSkillTwo() {
        Player player = new Player("a", null);
        Skill a = new Skill("a", 1, 1, null);
        Skill b = new Skill("b", 1, 1, null);
        boolean aAdded = player.addSkill(a);
        boolean bAdded = player.addSkill(b);
        assert(player.getSkillList().size() == 2);
        assert(player.getSkillList().indexOf(a) == 0);
        assert(player.getSkillList().indexOf(b) == 1);
        assert(aAdded);
        assert(bAdded);
    }

    @Test
    void addSkillAlreadyAdded() {
        Player player = new Player("a", null);
        Skill a = new Skill("a", 1, 1, null);
        boolean aAddedOnce = player.addSkill(a);
        boolean aAddedTwice = player.addSkill(a);
        assert(player.getSkillList().size() == 1);
        assert(player.getSkillList().indexOf(a) == 0);
        assert(aAddedOnce);
        assert(!aAddedTwice);
    }

    @Test
    void removeSkillEmpty() {
        Player player = new Player("a", null);
        Skill a = new Skill("a", 1, 1, null);
        player.removeSkill(a);
        assert(player.getSkillList().isEmpty());
    }

    @Test
    void removeSkillPresent() {
        Player player = new Player("a", null);
        Skill a = new Skill("a", 1, 1, null);
        player.addSkill(a);
        player.removeSkill(a);
        assert(player.getSkillList().isEmpty());
    }
}