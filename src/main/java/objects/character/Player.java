package objects.character;

public class Player extends Character {
    /** A class for the Player character. Includes getters and setters for all applicable attributes.
     * Attributes:
     * name: The name of the Player.
     * description: A description of the Player. Filled by the user at the start of the game.
     * currHealth: The current amount of health of the Player. Decreases and increases during a battle. Never exceeds
     *             maxHealth.
     * maxHealth: The maximum amount of health of the Player.
     * experience: The amount of experience points of the Player. Increases after completing tasks or killing enemies.
     * level: The level of the Player. Increases after experience points reach a certain value. Unlocks various new
     *        content for the Player, such as new skills and increased health.
     * type: The type of the player. Each int corresponds to an enum.
     * speed: The speed of the player. A higher int corresponds to a higher priority in a battle.
     * money: The amount of money the Player owns.
     */
    private String name;
    private String description;
    private int currHealth;
    private int maxHealth;
    private int experience;
    private int level;
    private int type;
    private int speed;
    private int money;

    public Player(String name, int type) {
        /* Initializes a new Player character with name and type, an empty description, 100 currHealth and maxHealth
        and speed, 0 experience and level, and 20 money.
         */
        super(name);
        this.description = "";
        this.type = type;
        this.currHealth = 100;
        this.maxHealth = 100;
        this.experience = 0;
        this.level = 0;
        this.speed = 100;
        this.money = 20;
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

    public void increaseMaxHealth(int changeBy) {
        // Increase the Player's maximum health by increaseBy.
        this.maxHealth += changeBy;
    }

    public int getExperience() {
        // Return the amount of experience points this Player has.
        return this.experience;
    }

    public void addExperience(int increaseBy) {
        // Add increaseBy experience points to the Player's experience.
        this.experience += increaseBy;
    }

    public int getLevel() {
        // Return the level of the Player.
        return this.level;
    }

    public void addLevel(int increaseBy) {
        // Add increaseBy levels to the Player's level.
        this.level += increaseBy;
    }

    public int getType() {
        // Return the int value of the type of the Player.
        return this.type;
    }

    public void changeType(int changeBy) {
        // Change the Player's type by changeBy.
        this.type += changeBy;
    }

    public int getSpeed() {
        // Return the speed of this Player.
        return this.speed;
    }

    public void changeSpeed(int newSpeed) {
        // Change the speed of the Player to newSpeed.
        this.speed = newSpeed;
    }

    public int getMoney() {
        // Return the amount of money this Player has.
        return this.money;
    }

    public void changeMoney(int changeBy) {
        // Change the amount of money the Player has by changeBy.
        this.money += changeBy;
    }

}
