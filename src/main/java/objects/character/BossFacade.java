package objects.character;

import objects.battle.enemy.*;
import objects.battle.enemy.gimmick.GimmickStrategy;
import objects.battle.enemy.ai.*;

/**
 * This class represents the boss in a game
 */
public class BossFacade extends EnemyFacade implements EnemyFighter{

    /**
     * gimmick: gimmick use case with the gimmick entity that enemy can use. This allows the class to
     * work as a facade, so the EnemyTurnState can use gimmick by a single method without knowing the
     * complexities of the system
     */
    private final GimmickStrategy gimmick;

    /**
     * This is a constructor of the boss
     *
     * @param name: name of the boss
     * @param enemyInfo: information about the enemy including health, skills, speed, and reputation
     * @param enemyAI: enemy AI that the boss has
     * @param gimmick : the gimmick that the boss has
     */
    public BossFacade(String name, EnemyInfo enemyInfo, EnemyAI enemyAI, GimmickStrategy gimmick)
    {
        super(name, enemyInfo, enemyAI);
        this.gimmick = gimmick;
    }

    /**
     * This method uses the gimmick and displays the string on the console
     *
     */
    public void applyGimmick(){
        this.gimmick.useGimmick();
    }
}
