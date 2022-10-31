import java.util.ArrayList;
import java.util.List;

public class Enemy extends NonPlayer{

    private int health;
    public ArrayList<Skill> skills;

    public Enemy() {
        super();
        this.health = 100;
        this.skills = new ArrayList<Skill>();
    }

    public void decreaseHP(int n) {
        this.health = this.health - n;
    }

    public void increaseHP(int n) {
        this.health = this.health + n;
    }

    public boolean check_alive() {
        if(this.health <= 0){
            return false;
        } else{
            return true;
        }
    }

    public int check_health(){
        return this.health;
    }

    public void set_skills(ArrayList<Skill> skills){
        this.skills = skills;
    }

}
