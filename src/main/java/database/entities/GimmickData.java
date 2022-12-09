package database.entities;

public class GimmickData {

    /**
     * All information needed for a gimmick
     */

    public final String name;
    public final String trigger;
    public String attack;
    public String speed;

    public GimmickData(String name, String trigger) {
        this.name = name;
        this.trigger = trigger;
    }
    public GimmickData(String name, String trigger, String extra) {
        this.name = name;
        this.trigger = trigger;
        if (this.name.equals("attack")) {
            this.attack = extra;
        }
        else if (this.name.equals("speed")){
            this.speed = extra;
        }
    }

}

