package database.entities;

import java.util.ArrayList;

public class EnemyData {

    /**
     * All information needed for an enemy
     */

    public final String name;
    public final String type;
    public final ArrayList<String> skills;
    public final String reputation;
    public final String speed;
    public final String ai;
    public String gimmick;
    public final String potion;

    public EnemyData(String name, String type, ArrayList<String> skills, String reputation, String speed, String ai,
                     String potion) {
        this.name = name;
        this.type = type;
        this.skills = skills;
        this.reputation = reputation;
        this.speed = speed;
        this.ai = ai;
        this.potion = potion;
    }
    public EnemyData(String name, String type, ArrayList<String> skills,
                     String reputation, String speed, String ai, String potion, String gimmick) {
        this.name = name;
        this.type = type;
        this.skills = skills;
        this.reputation = reputation;
        this.speed = speed;
        this.ai = ai;
        this.gimmick = gimmick;
        this.potion = potion;
    }
}

