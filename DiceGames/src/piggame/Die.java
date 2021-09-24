package piggame;

import java.util.Random;

public class Die {

    private int dieRoll;

    public Die() {
        dieRoll = 0;
    }

    public int roll() {
        Random rand = new Random();
        dieRoll = (int) rand.nextInt(6) + 1;
        return dieRoll;
    }
}
