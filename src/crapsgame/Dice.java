package crapsgame;

import java.util.Random;

public class Dice {

    private int dieRoll;

    public Dice() {
        dieRoll = 0;
    }

    public int roll() {
        Random rand = new Random();
        dieRoll = (int) rand.nextInt(6) + 1;
        return dieRoll;
    }
}