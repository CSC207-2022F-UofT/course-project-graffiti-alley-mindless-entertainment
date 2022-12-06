package game;

import objects.character.Player;
import options.Options;

public class GameEntities {
    private final Player player;
    private final Options options;

    public GameEntities() {
        player = new Player("", null);
        options = Options.getOptions();
    }

    public Player getPlayer() {
        return player;
    }

    public Options getOptions() {
        return options;
    }




}
