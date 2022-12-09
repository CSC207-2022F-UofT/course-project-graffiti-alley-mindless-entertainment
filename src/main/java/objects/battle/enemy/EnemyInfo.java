package objects.battle.enemy;

import objects.battle.skills.Skill;
import objects.battle.skills.SkillType;
import objects.battle.enemy.ai.EnemyPotion;

import java.util.ArrayList;

public class EnemyInfo {
    /**
     * maxHealth: max health that this enemy can have
     * health: current health of this enemy
     * skills: skills that the enemy has
     * speed: speed of this enemy
     * reputation: reputation that player gets when the player wins
     * type: type of this enemy
     * potion: the potion that this enemy has
     */
    private final int maxHealth = 100;
    private int health = maxHealth; //does not have to be static since there are multiple enemies and
    // we create an enemy every time the user encounters an enemy.
    private final ArrayList<Skill> skills;
    private int speed;
    private final int reputation;
    private SkillType type;
    private final EnemyPotion potion;

    /** This is a constructor of the EnemyInfo class
     * @param type type of the enemy
     * @param potion : potion that the enemy has
     * @param reputation : reputation that the player gets if the player beats this enemy.
     * @param skills : skills that the enemy has
     * @param speed : speed of this enemy
     */
    public EnemyInfo(ArrayList<Skill> skills, int speed, int reputation, SkillType type, EnemyPotion potion){
        this.skills = skills;
        this.reputation = reputation;
        this.speed = speed;
        this.type = type;
        this.potion = potion;
    }

    /**
     * This method returns the enemy's health
     *
     * @return  enemy's health in int
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * This method changes the Enemy's health
     * if n is positive, it will increase the health and
     * if its negative, it will decrease the health
     *
     * @param n: the amount of health to change in int
     */
    public void changeHealth(int n){
        if (this.health + n > this.maxHealth){
            this.setHealth(100);
        } else {
            this.health = Math.max(this.health + n, 0);
        }
    }

    /**
     * This method decreases the enemy's speed
     *
     * @param n: the amount of speed that the enemy looses by using a skill
     *
     */
    public void changeSpeed(int n){
        this.speed = this.speed + n;
    }


    /**
     * This returns the enemy's speed
     *
     * @return speed of this enemy in int
     */
    public int getSpeed(){
        return this.speed;
    }

    /**
     * This method checks if the enemy is alive or not
     * and return false if the enemy is dead
     *
     * @return true if the enemy is alive and return false
     * if the enemy is dead
     */
    public boolean checkAlive()
    {
        return this.health > 0;
    }

    /**
     * This function sets the enemy's health
     *
     * @param n: new health in int
     */
    public void setHealth(int n)
    {
        this.health = n;
    }

    /**
     * This method sets the enemy's speed
     *
     * @param speed: new speed in int
     */
    public void setSpeed(int speed)
    {
        this.speed = speed;
    }

    /**
     * This method returns the enemy's reputation
     *
     * @return the reputation that the player gets by killing this enemy
     */
    public int getReputation()
    {
        return this.reputation;
    }

    /**
     * This method returns the skill at index n
     *
     * @param n: the index of the skill
     * @return the skill at index n
     */
    public Skill getSkill(int n){
        return this.skills.get(n);
    }

    /**
     * This method returns the skills that the enemy has
     *
     * @return the skills as a arraylist of skill
     */
    public ArrayList<Skill> getSkills(){
        return this.skills;
    }

    /**
     * This method returns the type that the enemy has
     *
     * @return the enemy's type
     */
    public SkillType getType() {
        return this.type;
    }

    /**
     * This method sets the new type that the enemy  has
     *
     * @param type: new type of the enemy
     */
    public void setType(SkillType type){
        this.type = type;
    }

    /**
     * This method returns the maximum health that an enemy can have
     *
     * @return max health that the enemy can have
     */
    public int getMaxHealth(){
        return this.maxHealth;
    }

    /**
     * This method returns the EnemyPotion object that this enemy has
     *
     * @return potion that this enemy has
     */
    public EnemyPotion getPotion(){
        return this.potion;
    }
}
