package objects.battle.enemy.ai;

/**
 * This class is an interface for enemyAI. It has a method called respond that
 * is overridden by the subclasses, and it returns the enemy action that is decided by the
 * specific AI (subclass).
 */
public interface EnemyAI {


    /**
     * This method returns enemy's action depending on the user's action
     * @param input: user's action in string
     * @return EnemyActionHandler that represents the enemy's action
     */
    EnemyActionHandler respond(String input);
}
