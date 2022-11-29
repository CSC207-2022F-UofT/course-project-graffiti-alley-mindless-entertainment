package objects.character;

import objects.battle.enemy.*;
import objects.battle.enemy.ai.*;
import objects.battle.enemy.gimmick.Gimmick;

/**
 * This class represents the boss in a game
 */
public class Boss extends Enemy {

    private Gimmick gimmick;

    /**
     * This is a constructor of the boss
     *
     * @param name: name of the boss
     * @param enemyInfo: information about the enemy including health, skills, speed, and reputation
     * @param enemyAI: enemy AI that the boss has
     * @param gimmick : the gimmick that the boss has
     */
    public Boss(String name, EnemyInfo enemyInfo, EnemyAI enemyAI, Gimmick gimmick)
    {
        super(name, enemyInfo, enemyAI);
        this.gimmick = gimmick;
    }



    /**
     * This method returns the enemy's gimmick
     *
     */
    public Gimmick getGimmick() {
        return this.gimmick;
    }

}
