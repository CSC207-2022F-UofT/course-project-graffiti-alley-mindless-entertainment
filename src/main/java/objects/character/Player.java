package objects.character;

import objects.battle.SkillType;
import objects.battle.Skill;
import objects.inventory.Inventory;
import save.SavableEntity;
import save.SaveEntityId;

import java.util.ArrayList;

/**
 * A class for the Player character. Includes getters and setters for all applicable attributes.
 */
public class Player extends Character implements SavableEntity {
    /**
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
     * inventory: An Inventory of the player.
     */
    private String name;
    private String description;
    private int currHealth;
    private int maxHealth;
    private int armor;
    private int experience;
    private SkillType skillType;
    private int speed;
    private int money;
    private final ArrayList<Skill> skillList;
    public static int level = 0;
    public static Inventory inventory = new Inventory();

    /**
     * Initializes a new Player. Has an empty description, 100 currHealth/maxHealth/speed, 0 experience/armor/level,
     * 20 money, and an empty skillList.
     * @param name The name of the Player.
     * @param skillType The SkillType of the Player.
     */
    public Player(String name, SkillType skillType) {
        super(name);
        this.description = "";
        this.skillType = skillType;
        this.currHealth = 100;
        this.maxHealth = 100;
        this.armor = 0;
        this.experience = 0;
        this.speed = 100;
        this.money = 20;
        this.skillList = new ArrayList<>();
    }

    /**
     * @return The description of the Player.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Changes the description of the Player to newDesc.
     * @param newDesc The new description of the Player.
     */
    public void changeDescription(String newDesc) {
        this.description = newDesc;
    }

    /**
     * @return The amount of heal this Player currently has.
     */
    public int getCurrHealth() {
        return this.currHealth;
    }

    /**
     * Change the Player's current health by changeBy. Current health cannot be below zero, or higher than maxHealth.
     * currHealth is set to 0 if it decreases below 0, and set to maxHealth if it increases more than maxHealth.
     * @param changeBy The int to change currHealth by.
     */
    public void changeCurrHealth(int changeBy) {
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

    /**
     * @return The maximum amount of health this Player can have.
     */
    public int getMaxHealth() {
        return this.maxHealth;
    }

    /**
     * Change the Player's maximum health by changeBy. Maximum health cannot be <=0, so decreasing maxHealth to make
     * it negative sets maxHealth to 1.
     * @param changeBy The int to change maxHealth by.
     */
    public void changeMaxHealth(int changeBy) {
        int newMaxHealth = this.maxHealth + changeBy;
        if (newMaxHealth < 0) {
            this.maxHealth = 1;
        }
        else {
            this.maxHealth += changeBy;
        }
    }

    /**
     * @return The Player's armor points.
     */
    public int getArmor() {
        return this.armor;
    }

    /**
     * Change the Player's armor by changeBy. Armor points cannot be negative, so decreasing armor to make it negative
     * sets armor to 0.
     * @param changeBy The int to change armor by.
     */
    public void changeArmor(int changeBy) {
        int newArmor = this.armor + changeBy;
        if (newArmor < 0) {
            this.armor = 0;
        }
        else {
            this.armor += changeBy;
        }
    }

    /**
     * @return The amount of experience points this Player has.
     */
    public int getExperience() {
        return this.experience;
    }

    /**
     * Change the Player's experience by changeBy. Experience cannot be negative, so decreasing experience to make it
     * negative sets experience to 0.
     * @param changeBy The int to change experience by.
     */
    public void changeExperience(int changeBy) {
        int newExperience = this.experience + changeBy;
        if (newExperience < 0) {
            this.experience = 0;
        }
        else {
            this.experience += changeBy;
        }
    }

    /**
     * @return The level of the Player.
     */
    public static int getLevel() {
        return level;
    }

    /**
     * Change the Player's level by changeBy. Level cannot be negative, so decreasing level to make it negative sets
     * level to 0.
     * @param changeBy
     */
    public void changeLevel(int changeBy) {
        int newLevel = level + changeBy;
        if (newLevel < 0) {
            level = 0;
        }
        else {
            level += changeBy;
        }
    }

    /**
     * @return The SkillType of the Player.
     */
    public SkillType getSkillType() {
        // Return the SkillType of the Player.
        return this.skillType;
    }

    /**
     * @param newSkillType The new SkillType to change the Player's SkillType to.
     */
    public void changeSkillType(SkillType newSkillType) {
        this.skillType = newSkillType;
    }

    /**
     * @return The speed of the Player.
     */
    public int getSpeed() {
        return this.speed;
    }

    /**
     * @param changeBy The int to change the Player's speed by.
     */
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

    public static Inventory getInventory(){
        return inventory;
    }

    /**
     * @return a string representation of the object to be saved
     */
    @Override
    public String toSavableString() {
        return null;
    }

    /**
     * @param str a string representation
     *            map the string representation to the corresponding object
     */
    @Override
    public void fromSavableString(String str) {

    }

    /**
     * @return the id of this entity in the saved entities list
     */
    @Override
    public SaveEntityId getId() {
        return null;
    }
}
