package objects.character;
import objects.character.Character;

import java.util.ArrayList;
import java.util.List;

public class Enemy extends Character{

    private int health; //does not have to be static since there are multiple enemies and
    // we create an enemy every time the user encounters an enemy.
    public ArrayList<Skill> skills;
    private int speed;
    private int reputation;

    public Enemy(String name, int reputation) {
        super(name);
        this.health = 100;
        this.skills = new ArrayList<Skill>();
        this.speed = 90;
        this.reputation = reputation;
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

    public void set_skills(ArrayList<Skill> skills){
        this.skills = skills;
    }

    public int getHealth(){
        return this.health;
    }
    public void setHealth(int n){
        this.health = n;
    }

    public void change_speed(int n){
        this.speed = this.speed - n;
    }

    public int getSpeed(){
        return this.speed;
    }

    public void add_skill(Skill skill){
        this.skills.add(skill);
    }

    public int get_reputation(){
        return this.reputation;
    }

}
