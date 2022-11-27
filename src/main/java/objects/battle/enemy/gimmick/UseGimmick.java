package objects.battle.enemy.gimmick;

import objects.character.Boss;

public class UseGimmick {
    private Boss boss;

    public UseGimmick(Boss boss){
        this.boss = boss;
    }

    /**
     * This method uses gimmick by calling a method in gimmick class. Returns true
     * if the gimmick is successfully used and return false if its not triggered yet.
     *
     * @return true if the gimmick is used and false if its not triggered or
     * if its already used once.
     */
    public boolean applyGimmick(){
        if(!this.boss.checkGimmick() && this.boss.getGimmick().checkGimmick()){
            this.boss.usedGimmick();
            this.boss.getGimmick().useGimmick();
            return true;
        } else{
            return false;
        }

    }
}
