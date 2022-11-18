package data_objects;

import java.util.ArrayList;
import java.util.HashMap;

public class AreaData {

    public String name;

    public String speaker;
    public ArrayList<String> texts;

    public String next;
    public HashMap<String, String> options;

    public AreaData(String name, String speaker, ArrayList<String> texts, String next) {
        this.name = name;
        this.speaker = speaker;
        this.texts = texts;
        this.next = next;
    }

    public AreaData(String name, String speaker, ArrayList<String> texts, HashMap<String,String> options) {
        this.name = name;
        this.speaker = speaker;
        this.texts = texts;
        this.options = options;
    }
}

