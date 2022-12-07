package game;

import game_world.objects.Location;
import objects.character.Player;
import objects.inventory.Inventory;
import options.Options;

/**
 * This class is used to initialize all the entities, and provide getters for each of them.
 *
 */
public class GameEntities {
    private final Player player;
    private final Options options;

    private final Inventory inventory;
    private final Location location;


    public GameEntities() {
        player = new Player("", null);
        inventory = Player.getInventory();
        options = Options.getOptions();
        location = new Location();
    }

    public Player getPlayer() {
        return player;
    }

    public Options getOptions() {
        return options;
    }

    public Inventory getInventory() {
        return inventory;
    }


    public Location getLocation() {
        return location;
    }
}
