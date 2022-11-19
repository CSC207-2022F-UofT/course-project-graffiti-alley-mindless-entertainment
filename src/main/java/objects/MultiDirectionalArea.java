package objects;

import java.util.ArrayList;
import java.util.Map;

public class MultiDirectionalArea extends Area {
    public Map<String, String> options;

    public MultiDirectionalArea(String name, String speaker, ArrayList<String> texts,  Map<String, String> options) {
        this.name = name;
        this.type = "Multi-Directional";
        this.speaker = speaker;
        this.texts = texts;
        this.options = options;
    }
}
