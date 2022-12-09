package battle.use_cases;


import character.EnemyFighter;
import character.entities.Player;

/**
 * This class is a use case that deals with action made by an enemy
 */
public interface EnemyActionHandler {

    /**
     * This method useAction uses the action depending on the object that
     * the handler has
     * @param enemy that used the action
     * @param player of the game. Enemy uses the action to this player
     */
    void useAction(EnemyFighter enemy, Player player);


}
