package objects;

import java.util.ArrayList;

public class OneWayArea extends Area {
    public String next;

    public OneWayArea(String name, String speaker, ArrayList<String> texts, String next) {
        this.name = name;
        this.type = "One-Way";
        this.speaker = speaker;
        this.texts = texts;
        this.next = next;
    }
}
