package objects.character;

import Enemy_Entities.Gimmick;
/**
 * This class represents the boss in a game
 */
public class Boss extends Enemy {

    private Gimmick gimmickSet;
    private boolean GimmickUsed;

    /**
     * This is a constructor of the boss
     *
     * @param name: name of the boss
     * @param reputation: reputation that the user gets by killing the enemy in int
     */
    public Boss(String name, int reputation)
    {
        super(name, reputation);

        this.gimmickSet = null;
        this.GimmickUsed = false;
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
        this.gimmickSet = gimmick;
    }

}
