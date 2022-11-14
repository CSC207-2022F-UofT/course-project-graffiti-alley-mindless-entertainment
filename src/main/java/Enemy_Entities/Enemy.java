import java.util.ArrayList;
import java.util.List;

public class Enemy extends NonPlayer{

    private int health;
    public ArrayList<Skill> skills;
    private int speed;

    public Enemy(String name, int reputation) {
        super(name, reputation);
        health = 100;
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

    public int getHealth(){
        return this.health;
    }
    public void set_health(int n){
        this.health = n;
    }

    public void change_speed(int n){
        this.speed = this.speed - n;
    }

    public int getSpeed(){
        return this.speed;
    }

}
