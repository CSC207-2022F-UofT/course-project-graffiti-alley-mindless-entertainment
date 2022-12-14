package game;

import game_world.entities.Location;
import battle.entities.Skill;
import battle.entities.SkillType;
import character.entities.Player;
import inventory.entities.Inventory;
import pause_menu.options.Options;

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
        player.addSkill(new Skill("torch", 5, 10, SkillType.FIRE));
        player.addSkill(new Skill("spit", 20, 10, SkillType.WATER));
        player.addSkill(new Skill("pebble throw", 71, 10, SkillType.EARTH));
        player.addSkill(new Skill("sneeze", 20, 10, SkillType.AIR));
        player.addSkill(new Skill("tsunami", 90, 40, SkillType.WATER));
        inventory = new Inventory();
        options = Options.getOptions();
        options.setEnableAutoSave(true);
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
