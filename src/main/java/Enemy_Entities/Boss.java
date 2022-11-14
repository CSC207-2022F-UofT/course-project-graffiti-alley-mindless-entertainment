package Enemy_Entities;

import Enemy_Entities.Enemy;

public class Boss extends Enemy {
    private Gimmick gimmick_set;
    private boolean Gimmick_used;

    public Boss(String name, int reputation) {
        super(name, reputation);

        this.gimmick_set = null;
        this.Gimmick_used = false;
    }
    public boolean get_gimmick_used(){
        return this.Gimmick_used;
    }

    public void used_Gimmick(){
        this.Gimmick_used = true;
    }

    public void setGimmick_set(Gimmick gimmick){
        this.gimmick_set = gimmick;
    }




}
