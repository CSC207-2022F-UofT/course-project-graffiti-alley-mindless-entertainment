package objects.battle.enemy.ai;

public class EnemyPotion implements EnemyAction{
    private int hp;

    public EnemyPotion(int hp){
        this.hp = hp;
    }

    public int getHp(){
        return this.hp;
    }
}
