package Battle.Enemy;

public interface EnemyAI {
    /**
     * @param input: input from the user in string
     * @return enemy's response to the input in string
     */
    public String respond(String input, BattleInfo info);
}
