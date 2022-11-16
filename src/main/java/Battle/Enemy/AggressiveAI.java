package Battle.Enemy;

import java.util.Objects;
import java.util.Random;

public class AggressiveAI implements EnemyAI{
    /**
     * Aggressive enemy AI that uses skill more often
     */
    public AggressiveAI(){super();}

    /**
     * @param input: input from the user in string
     * @return enemy's response to the input in string
     */
    @Override
    public String respond(String input) {
        if (Objects.equals(input, "use skill")) {
            Random rand = new Random();
            int upperbound = 101;
            int int_random = rand.nextInt(upperbound);
            if(int_random > 10){
                return "use skill";
            } else{
                return "use portion";
            }
        } else{
            return "use skill";
        }
    }

}
