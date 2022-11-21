package database.objects;

public class GimmickData {

    /**
     * All information needed for an arbitrary gimmick
     */

    public String name;
    public String trigger;
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

