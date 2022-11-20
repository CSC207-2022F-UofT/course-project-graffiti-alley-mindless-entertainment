package database.objects;

import java.util.ArrayList;

public class EnemyData {

    /**
     * All information needed for an arbitrary event
     */

    public String name;
    public String type;
    public ArrayList<String> skills;
    public String reputation;
    public String speed;
    public String ai;
    public String gimmick;

    public EnemyData(String name, String type, ArrayList<String> skills, String reputation, String speed, String ai) {
        this.name = name;
        this.type = type;
        this.skills = skills;
        this.reputation = reputation;
        this.speed = speed;
        this.ai = ai;
    }
    public EnemyData(String name, String type, ArrayList<String> skills,
                     String reputation, String speed, String ai, String gimmick) {
        this.name = name;
        this.type = type;
        this.skills = skills;
        this.reputation = reputation;
        this.speed = speed;
        this.ai = ai;
        this.gimmick = gimmick;
    }
}

