package objects.character;
import Enemy_Entities.EnemyInfo;
import objects.character.Character;

import java.util.ArrayList;
import java.util.List;


/**
 * This is a class for enemy that inherits character class. This enemy class includes
 * health, skills, speed, reputation and Enemy AI in addition to name which is inherited from
 * parent class.
 */
public class Enemy extends Character {


    public EnemyInfo enemyInfo;
    private EnemyAI enemyAI;

    /**
     * This is a constructor of the enemy.
     *
     * @param name: name if the enemy
     * @param enemyInfo: information about the enemy including health, skills, speed, and reputation
     * @param enemyAI: enemyAI that the enemy has
     */
    public Enemy(String name, EnemyInfo enemyInfo, EnemyAI enemyAI) {
        super(name);
        this.enemyAI = enemyAI;
        this.enemyInfo = enemyInfo;
    }

    public String enemyAction(String input, EnemyInfo enemyInfo){
        return this.enemyAI.respond(input, enemyInfo);
    }
}

