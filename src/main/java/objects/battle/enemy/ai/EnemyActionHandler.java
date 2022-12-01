package objects.battle.enemy.ai;

import objects.character.BossFacade;
import objects.character.EnemyFacade;
import objects.character.Player;

public interface EnemyActionHandler {
    public void useAction(EnemyFacade enemy, Player player);

    public void useAction(BossFacade boss, Player player);
}
