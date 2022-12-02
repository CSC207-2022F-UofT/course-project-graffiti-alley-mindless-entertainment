package objects.character;

import objects.battle.enemy.*;
import objects.battle.enemy.gimmick.GimmickStrategy;
import objects.battle.enemy.ai.*;

/**
 * This class represents the boss in a game
 */
public class BossFacade extends EnemyFacade implements EnemyFighter{

    private GimmickStrategy gimmick;

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
     * This method returns the enemy's gimmick
     *
     */
    public GimmickStrategy getGimmick() {
        return this.gimmick;
    }

    public String applyGimmick(){
        return gimmick.useGimmick();
    }
}
