package objects.character;

import objects.battle.Skill;
import objects.battle.SkillType;
import objects.battle.enemy.ai.EnemyAI;
import objects.battle.enemy.ai.EnemyActionHandler;
import objects.battle.enemy.ai.EnemyPotion;

import java.util.ArrayList;

public interface EnemyFighter {
    /**
     * This method returns the enemy's health
     *
     * @return  enemy's health in int
     */
    int getHealth();

    /**
     * This method changes the Enemy's health
     * if n is positive, it will increase the health and
     * if its negative, it will decrease the health
     *
     * @param n: the amount of health to change in int
     */
    void changeHealth(int n);

    /**
     * This method decreases the enemy's speed
     *
     * @param n: the amount of speed that the enemy looses by using a skill
     *
     */
    void changeSpeed(int n);


    /**
     * This returns the enemy's speed
     *
     * @return speed of this enemy in int
     */
    int getSpeed();

    /**
     * This method checks if the enemy is alive or not
     * and return false if the enemy is dead
     *
     * @return true if the enemy is alive and return false
     * if the enemy is dead
     */
    boolean checkAlive();

    /**
     * This function sets the enemy's health
     *
     * @param n: new health in int
     */
    void setHealth(int n);

    /**
     * This method sets the enemy's speed
     *
     * @param speed: new speed in int
     */
    void setSpeed(int speed);

    /**
     * This method returns the enemy's reputation
     *
     * @return the reputation that the player gets by killing this enemy
     */
    int getReputation();

    /**
     * This method returns the skill at index n
     *
     * @param n: the index of the skill
     * @return the skill at index n
     */
    Skill getSkill(int n);

    /**
     * This method returns the skills that the enemy has
     *
     * @return the skills as a arraylist of skill
     */
    ArrayList<Skill> getSkills();

    /**
     * This method returns the type that the enemy has
     *
     * @return the enemy's type
     */
    SkillType getType();

    /**
     * This method sets the new type that the enemy  has
     *
     * @param type: new type of the enemy
     */
    void setType(SkillType type);

    /**
     * This method returns the enemy actions depending on the user's action
     *
     * @param input: input by the user
     * @return enemy's action in string (use skill or use potion)
     */
    EnemyActionHandler enemyAction(String input);

    /**
     * This method returns the AI that the enemy has
     *
     * @return enemy's type of enemyAI
     */
    EnemyAI getEnemyAI();

    /**
     * This method returns the potion that this enemy has
     *
     * @return the potion that the enemy has
     */
    EnemyPotion getPotion();
}
