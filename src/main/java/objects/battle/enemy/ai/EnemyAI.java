package objects.battle.enemy.ai;

public interface EnemyAI {

    /**
     * This method returns enemy's action depending on the user's action
     * @param input: user's action in string
     * @return string that represents the enemy's action
     */
    public EnemyAction respond(String input);
}
