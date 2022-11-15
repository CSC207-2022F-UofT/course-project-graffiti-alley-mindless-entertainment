package objects.character;
import objects.character.Character;

import java.util.ArrayList;
import java.util.List;

public class Enemy extends Character{
    /**
     * This is a class for enemy that inherits character class. This enemy class includes
     * health, skills, speed, and reputation in addition to name which is inherited from
     * parent class.
     * Attributes:
     */

    private int health; //does not have to be static since there are multiple enemies and
    // we create an enemy every time the user encounters an enemy.
    public ArrayList<Skill> skills;
    private int speed;
    private int reputation;

    public Enemy(String name, int reputation) {
        /**
         * This is a constructor of the enemy.
         *
         * @param name:
         */
        super(name);
        this.health = 100;
        this.skills = new ArrayList<Skill>();
        this.speed = 90;
        this.reputation = reputation;
    }

    public void decreaseHP(int n)
    /**
     * This is a constructor of the enemy.
     *
     * @param name:
     */{
        this.health = this.health - n;
    }

    public void increaseHP(int n)
    /**
     * this method increases the enemy's health by n
     *
     * @param
     */{
        this.health = this.health + n;
    }

    public boolean checkAlive()
    /**
     * This method checks if the enemy is alive or not
     * and return false if the enemy is dead
     *
     * @param
     * @return
     */{
        if(this.health <= 0){
            return false;
        } else{
            return true;
        }
    }

    public int getHealth()
    /**
     * This is method returns the enemy's health
     *
     * @param
     * @return
     */{
        return this.health;
    }
    public void setHealth(int n)
    /**
     * This function sets the enemy's health
     *
     * @param
     * @return
     */{
        this.health = n;
    }

    public void setSpeed(int speed)
    /**
     * This method sets the enemy's speed
     *
     * @param
     * @return
     */{
        this.speed = speed;
    }

    public void changeSpeed(int n)
    /**
     * This method decreases the enemy's speed
     *
     * @param
     * @return
     */{
        this.speed = this.speed - n;
    }

    public int getSpeed()
    /**
     * This returns the enemy's speed
     *
     * @param
     * @return
     */{
        return this.speed;
    }

    public void addSkill(Skill skill)
    /**
     * This method add a skill to enemy's skills
     *
     * @param
     * @return
     */{
        this.skills.add(skill);
    }

    public int getReputation()
    /**
     * This imethod returns the enemy's reputation
     *
     * @param
     * @return
     */{
        return this.reputation;
    }

}
