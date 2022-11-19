package database.data_objects;

import java.util.ArrayList;
import java.util.Map;

public class AreaData {

    public String name;
    public String type;
    public String speaker;
    public ArrayList<String> texts;
    public String next;
    public Map<String, String> options;

    public AreaData(String name, String type, String speaker, ArrayList<String> texts, String next) {
        this.name = name;
        this.type = type;
        this.speaker = speaker;
        this.texts = texts;
        this.next = next;
    }

    public AreaData(String name, String type, String speaker, ArrayList<String> texts, Map<String,String> options) {
        this.name = name;
        this.type = type;
        this.speaker = speaker;
        this.texts = texts;
        this.options = options;
    }
}

