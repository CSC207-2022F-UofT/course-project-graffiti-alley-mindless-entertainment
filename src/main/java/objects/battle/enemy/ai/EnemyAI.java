package objects.battle.enemy.ai;

public interface EnemyAI {
    /**
     * This class is an interface for enemyAI. It has an a method called respond that
     * is overridden by the subclasses, and it returns the enemy action that is decided by the
     * specific AI (subclass).
     */

    /**
     * This method returns enemy's action depending on the user's action
     * @param input: user's action in string
     * @return string that represents the enemy's action
     */
    EnemyAction respond(String input);
}
