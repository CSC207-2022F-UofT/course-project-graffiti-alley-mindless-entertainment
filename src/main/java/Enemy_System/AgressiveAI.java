package Enemy_system;

import java.util.Objects;
import java.util.Random;

public class AgressiveAI implements EnemyAI {
    public AgressiveAI(){super();}

    @Override
    public String respond(String input) {
        if (Objects.equals(input, "use skill")) {
            Random rand = new Random(); //instance of random class
            int upperbound = 101;
            int int_random = rand.nextInt(upperbound);
            if(int_random > 5){
                return "use skill";
            } else{
                return "use portion";
            }
        } else{
            return "use skill";
        }
    }
}
