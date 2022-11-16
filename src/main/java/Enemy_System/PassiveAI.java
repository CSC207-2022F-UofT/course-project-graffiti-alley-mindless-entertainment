package Enemy_System;

import Enemy_system.EnemyAI;

import java.util.Objects;
import java.util.Random;

public class PassiveAI implements EnemyAI {
    public PassiveAI(){super();}

    @Override
    public String respond(String input) {
        if (Objects.equals(input, "use skill")) {
            Random rand = new Random();
            int upperbound = 101;
            int int_random = rand.nextInt(upperbound);
            if(int_random > 40){
                return "use skill";
            } else{
                return "use portion";
            }
        } else{
            return "use skill";
        }
    }
}
