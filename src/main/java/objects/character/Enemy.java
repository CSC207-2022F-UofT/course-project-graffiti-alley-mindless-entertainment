package objects.character;
import objects.character.Character;

import java.util.ArrayList;
import java.util.List;


/**
 * This is a class for enemy that inherits character class. This enemy class includes
 * health, skills, speed, and reputation in addition to name which is inherited from
 * parent class.
 */
public class Enemy extends Character{


    private int health; //does not have to be static since there are multiple enemies and
    // we create an enemy every time the user encounters an enemy.
    public ArrayList<Skill> skills;
    private int speed;
    private int reputation;

    /**
     * This is a constructor of the enemy.
     *
     * @param name: name if the enemy
     * @param reputation: reputation that the user gets by killing enemy in int
     */
    public Enemy(String name, int reputation) {

        super(name);
        this.health = 100;
        this.skills = new ArrayList<Skill>();
        this.speed = 90;
        this.reputation = reputation;
    }

    /**
     * This method changes the Enemy's health
     * if n is positive, it will increase the health and
     * if its negative, it will decrease the health
     *
     * @param n: the amount of health to change in int
     */
    public void changeHealth(int n)
    {
        this.health = this.health + n;
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
        if(this.health <= 0){
            return false;
        } else{
            return true;
        }
    }

    /**
     * This is method returns the enemy's health
     *
     * @return the enemy's health in int
     */
    public int getHealth()
    {
        return this.health;
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
     * This method decreases the enemy's speed
     *
     * @param n: the amount of speed that the enemy looses by using a skill
     *
     */
    public void changeSpeed(int n)
    {
        this.speed = this.speed - n;
    }

    /**
     * This returns the enemy's speed
     *
     * @return speed of this enemy in int
     */
    public int getSpeed()
    {
        return this.speed;
    }

    /**
     * This method add a skill to enemy's skills
     *
     * @param skill: skill entity
     */
    public void addSkill(Skill skill)
    {
        this.skills.add(skill);
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

}
