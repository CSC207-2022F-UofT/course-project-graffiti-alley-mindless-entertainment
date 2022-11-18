package managers;

import objects.Area;

import java.util.ArrayList;
import java.util.Hashtable;

public class AreaManager {

    private Hashtable<Area, ArrayList<Area>> worldMap = new Hashtable<Area, ArrayList<Area>>();
    private DatabaseManager database;
    private String currentChapter;
    public Area currentArea;

    public AreaManager(String chapter) {
        this.currentChapter = chapter;

    }

}
