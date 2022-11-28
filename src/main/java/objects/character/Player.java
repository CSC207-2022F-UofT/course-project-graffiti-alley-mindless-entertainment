package objects.character;

import objects.battle.SkillType;
import objects.battle.Skill;

import java.util.ArrayList;

public class Player extends Character {
    /** A class for the Player character. Includes getters and setters for all applicable attributes.
     * Attributes:
     * name: The name of the Player.
     * description: A description of the Player. Filled by the user at the start of the game.
     * currHealth: The current amount of health of the Player. Decreases and increases during a battle. Never exceeds
     *             maxHealth.
     * maxHealth: The maximum amount of health of the Player.
     * armor: The armor points of the Player.
     * experience: The amount of experience points of the Player. Increases after completing tasks or killing enemies.
     * level: The level of the Player. Increases after experience points reach a certain value. Unlocks various new
     *        content for the Player, such as new skills and increased health.
     * skillType: The skill type of the Player. Utilizes the SkillType enum.
     * speed: The speed of the Player. A higher int corresponds to a higher priority in a battle.
     * money: The amount of money the Player owns.
     * skillList: A List of Skills of the Player.
     * inventory: An Inventory of the Player. Awaiting Inventory implementation.
     */
    private String name;
    private String description;
    private int currHealth;
    private int maxHealth;
    private int armor;
    private int experience;
    private int level;
    private SkillType skillType;
    private int speed;
    private int money;
    private final ArrayList<Skill> skillList;

    public Player(String name, SkillType skillType) {
        // Initializes a new Player character with name and skillType, an empty description, 100 currHealth,
        // maxHealth and speed, 0 experience, armor and level, 20 money, and an empty skillList.
        super(name);
        this.description = "";
        this.skillType = skillType;
        this.currHealth = 100;
        this.maxHealth = 100;
        this.armor = 0;
        this.experience = 0;
        this.level = 0;
        this.speed = 100;
        this.money = 20;
        this.skillList = new ArrayList<>();
    }

    public String getDescription() {
        // Return the description of the Player.
        return this.description;
    }

    public void changeDescription(String newDesc) {
        // Change the description of the Player to newDesc.
        this.description = newDesc;
    }

    public int getCurrHealth() {
        // Return the amount of health this Player currently has.
        return this.currHealth;
    }

    public void changeCurrHealth(int changeBy) {
        // Change the Player's current health by changeBy. Current health cannot be below zero, or higher than
        // maxHealth. currHealth is set to 0 if it decreases below 0, and set to maxHealth if it increases more than
        // maxHealth.
        int newHealth = this.currHealth + changeBy;
        if (newHealth < 0) {
            this.currHealth = 0;
        }
        else if (newHealth > this.maxHealth) {
            this.currHealth = this.maxHealth;
        }
        else {
            this.currHealth = newHealth;
        }
    }

    public int getMaxHealth() {
        // Return the maximum amount of health this Player can have.
        return this.maxHealth;
    }

    public void changeMaxHealth(int changeBy) {
        // Change the Player's maximum health by changeBy. Maximum health cannot be <=0, so decreasing maxHealth
        // to make it negative sets maxHealth to 1.
        int newMaxHealth = this.maxHealth + changeBy;
        if (newMaxHealth < 0) {
            this.maxHealth = 1;
        }
        else {
            this.maxHealth += changeBy;
        }
    }

    public int getArmor() {
        // Returns the Player's armor points.
        return this.armor;
    }

    public void changeArmor(int changeBy) {
        // Change the Player's armor by changeBy. Armor points cannot be negative, so decreasing armor to make it
        // negative sets armor to 0.
        int newArmor = this.armor + changeBy;
        if (newArmor < 0) {
            this.armor = 0;
        }
        else {
            this.armor += changeBy;
        }
    }

    public int getExperience() {
        // Return the amount of experience points this Player has.
        return this.experience;
    }

    public void changeExperience(int changeBy) {
        // Change the Player's experience by changeBy. Experience cannot be negative, so decreasing experience to make
        // it negative sets experience to 0.
        int newExperience = this.experience + changeBy;
        if (newExperience < 0) {
            this.experience = 0;
        }
        else {
            this.experience += changeBy;
        }
    }

    public int getLevel() {
        // Return the level of the Player.
        return this.level;
    }

    public void changeLevel(int changeBy) {
        // Change the Player's level by changeBy. Level cannot be negative, so decreasing level to make it negative
        // sets level to 0.
        int newLevel = this.level + changeBy;
        if (newLevel < 0) {
            this.level = 0;
        }
        else {
            this.level += changeBy;
        }
    }

    public SkillType getSkillType() {
        // Return the SkillType of the Player.
        return this.skillType;
    }

    public void changeSkillType(SkillType newSkillType) {
        // Change the Player's SkillType to newSkillType.
        this.skillType = newSkillType;
    }

    public int getSpeed() {
        // Return the speed of this Player.
        return this.speed;
    }

    public void changeSpeed(int changeBy) {
        // Change the speed of the Player by changeBy.
        this.speed += changeBy;
    }

    public int getMoney() {
        // Return the amount of money this Player has.
        return this.money;
    }

    public void changeMoney(int changeBy) {
        // Change the amount of money the Player has by changeBy.
        this.money += changeBy;
    }

    public ArrayList<Skill> getSkillList() {
        // Returns the skillList of the Player.
        return this.skillList;
    }

    public boolean addSkill(Skill newSkill) {
        // Append a new Skill to the end of skillList iff newSkill is not already in skillList. Returns true if
        // successful.
        if (!this.skillList.contains(newSkill)) {
            this.skillList.add(newSkill);
            return true;
        }
        else {
            return false;
        }
    }

    public void removeSkill(Skill toRemove) {
        // Remove toRemove from skillList.
        this.skillList.remove(toRemove);
    }

}
