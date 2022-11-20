package objects.character;

import objects.battle.enemy.*;
import objects.battle.enemy.gimmick.Gimmick;
import objects.battle.enemy.ai.*;

/**
 * This class represents the boss in a game
 */
public class Boss extends Enemy {

    private Gimmick gimmick;
    private boolean GimmickUsed;

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
        this.GimmickUsed = false;
    }

    public boolean useGimmick(){
        if(!this.GimmickUsed && this.gimmick.checkGimmick()){
            this.GimmickUsed = true;
            this.gimmick.useGimmick();
            return true;
        } else{
            return false;
        }

    }

    /**
     * This method checks if the gimmick is used or not
     *
     * @return boolean representing if the gimmick is used.
     * return true if the gimmick is used
     */
    public boolean checkGimmick()
    {
        return this.GimmickUsed;
    }

    /**
     * This method changes the GimmickUsed to true to indicate the
     * gimmick is used
     *
     *
     */
    public void usedGimmick()
    {
        this.GimmickUsed = true;
    }

    /**
     * This method sets the gimmick for an enemy
     *
     * @param gimmick: gimmick entity
     */
    public void setGimmick(Gimmick gimmick)
    {
        this.gimmick = gimmick;
    }

    /**
     * This method returns the enemy's gimmick
     *
     */
    public Gimmick getGimmickSet() {
        return gimmick;
    }
}
