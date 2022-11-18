package Enemy_system;
package objects.charactoers.player;
public class DamageGimmick implements Gimmick{
    private EnemyInfo enemyInfo;
    private PlayerInfo playerInfo;

    public DamageGimmick(EnemyInfo enemyInfo, PlayerInfo playerInfo){
        this.enemyInfo = enemyInfo;
        this.playerInfo = playerInfo;
    }

    public void useGimmick(){ // return true if the gimmick has been used by the boss. This method
        // returns boolean because if the gimmick is used, maybe some dialouges will be called in battle state class.
        //(whenever this method return true)
        int damage = Math.ceil(this.playerInfo.checkHealth()*0.5);
        this.playerInfo.changeHealth(-damage);
    }

    public boolean checkGimmick(){
        if(this.enemyInfo.getHealth() < 20){
            return true;
        } else{
            return false;
        }
    }

}
