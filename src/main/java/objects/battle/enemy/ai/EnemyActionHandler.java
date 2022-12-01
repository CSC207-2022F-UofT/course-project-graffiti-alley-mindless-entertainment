package objects.battle.enemy.ai;

import objects.character.BossFacade;
import objects.character.EnemyFacade;
import objects.character.Player;

public interface EnemyActionHandler {

    /**
     * This method useAction uses the action depending on the object that
     * the handler has
     * @param enemy that used the action
     * @param player of the game. Enemy uses the action to this player
     */
    public void useAction(EnemyFacade enemy, Player player);

    /**
     * This method useAction uses the action depending on the object that
     * the handler has
     * @param boss that used the action
     * @param player of the game. Enemy uses the action to this player
     */
    public void useAction(BossFacade boss, Player player);
}
