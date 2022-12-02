package objects.character;
import objects.battle.Skill;
import objects.battle.SkillType;
import objects.battle.enemy.EnemyInfo;
import objects.battle.enemy.ai.*;

import java.util.ArrayList;


/**
 * This is a class for enemy that inherits character class. This enemy class includes
 * health, skills, speed, reputation and Enemy AI in addition to name which is inherited from
 * parent class.
 */
public class EnemyFacade extends Character implements EnemyFighter{


    public EnemyInfo enemyInfo;
    private EnemyAI enemyAI;

    /**
     * This is a constructor of the enemy.
     *
     * @param name: name if the enemy
     * @param enemyInfo: information about the enemy including health, skills, speed, and reputation
     * @param enemyAI: enemyAI that the enemy has
     */
    public EnemyFacade(String name, EnemyInfo enemyInfo, EnemyAI enemyAI) {
        super(name);
        this.enemyAI = enemyAI;
        this.enemyInfo = enemyInfo;
    }

    /**
     * This method returns the enemy's health
     *
     * @return  enemy's health in int
     */
    public int getHealth() {
        return this.enemyInfo.getHealth();
    }

    /**
     * This method changes the Enemy's health
     * if n is positive, it will increase the health and
     * if its negative, it will decrease the health
     *
     * @param n: the amount of health to change in int
     */
    public void changeHealth(int n){
        this.enemyInfo.changeHealth(n);
    }

    /**
     * This method decreases the enemy's speed
     *
     * @param n: the amount of speed that the enemy looses by using a skill
     *
     */
    public void changeSpeed(int n){
        this.enemyInfo.changeSpeed(n);
    }


    /**
     * This returns the enemy's speed
     *
     * @return speed of this enemy in int
     */
    public int getSpeed(){
        return this.enemyInfo.getSpeed();
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
        return this.enemyInfo.checkAlive();
    }

    /**
     * This function sets the enemy's health
     *
     * @param n: new health in int
     */
    public void setHealth(int n)
    {
        this.enemyInfo.setHealth(n);
    }

    /**
     * This method sets the enemy's speed
     *
     * @param speed: new speed in int
     */
    public void setSpeed(int speed)
    {
        this.enemyInfo.setSpeed(speed);
    }

    /**
     * This method returns the enemy's reputation
     *
     * @return the reputation that the player gets by killing this enemy
     */
    public int getReputation()
    {
        return this.enemyInfo.getReputation();
    }

    /**
     * This method returns the skill at index n
     *
     * @param n: the index of the skill
     * @return the skill at index n
     */
    public Skill getSkill(int n){
        return this.enemyInfo.getSkill(n);
    }

    /**
     * This method returns the skills that the enemy has
     *
     * @return the skills as a arraylist of skill
     */
    public ArrayList<Skill> getSkills(){
        return this.enemyInfo.getSkills();
    }

    /**
     * This method returns the type that the enemy has
     *
     * @return the enemy's type
     */
    public SkillType getType() {
        return this.enemyInfo.getType();
    }

    /**
     * This method sets the new type that the enemy  has
     *
     * @param type: new type of the enemy
     */
    public void setType(SkillType type){
        this.enemyInfo.setType(type);
    }

    /**
     * This method returns the enemy actions depending on the user's action
     *
     * @param input: input by the user
     * @return enemy's action in string (use skill or use potion)
     */
    public EnemyActionHandler enemyAction(String input){
        return this.enemyAI.respond(input);
    }

    public EnemyAI getEnemyAI() {
        return this.enemyAI;
    }

    public EnemyPotion getPotion(){
        return this.enemyInfo.getPotion();
    }
}

