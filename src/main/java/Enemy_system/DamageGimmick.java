package Enemy_system;
package objects.charactoers.player;
public class DamageGimmick {
    public DamageGimmick(){
        super();
    }

    public boolean use_gimmick(Boss boss, Player player){ // return true if the gimmick has been used by the boss. This method
        // returns boolean because if the gimmick is used, maybe some dialouges will be called in battle state class.
        //(whenever this method return true)
        if(check_gimmick(boss)){
            int damage = Math.ceil(player.checkHealth()*0.5);
            player.changeHealth(-damage);
            boss.usedGimmick();
            return true;
        } else{
            return false;
        }
    }

    public boolean check_gimmick(Boss boss){
        if(boss.getHealth() < 20){
            return true;
        } else{
            return false;
        }
    }

}
