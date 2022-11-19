package objects.battle.enemy.gimmick;

public interface Gimmick {

    /**
     * This method ues gimmick depending on the gimmick that an enemy has
     */
    public void useGimmick(); //return true if the gimmick has used

    /**
     * This method checks if the gimmick is triggered or not
     * @return true if the gimmick is triggered
     */
    public boolean checkGimmick();



}

