package crapsgame;

import java.util.Scanner;

public class CrapsApp {
    public static void main(String[] args) {
        // Create the game objects
        Dice die1 = new Dice();
        Dice die2 = new Dice();
        Scanner scan = new Scanner(System.in);

        while (true) {

            // Roll the dice for the first time
            System.out.println("Start of the game!");

            System.out.println("Press [Enter] to roll the dice");
            scan.nextLine();
            int roll1 = die1.roll();
            int roll2 = die2.roll();
            int rollTotal = roll1 + roll2;
            System.out.println("Dice1: " + roll1);
            System.out.println("Dice2: " + roll2);
            System.out.println("Total: " + rollTotal);

            // Find out if you won
            if (rollTotal == 7 || rollTotal == 11) {
                System.out.println("You WON!");
            } else {
                if (rollTotal == 2 || rollTotal == 3 || rollTotal == 12) {
                    System.out.println("You LOST!");
                } else {
                    int points = rollTotal;

                    boolean reRoll = true;

                    while (reRoll) {
                        System.out.println("Press [Enter] to roll the dice");
                        scan.nextLine();
                        roll1 = die1.roll();
                        roll2 = die2.roll();
                        rollTotal = roll1 + roll2;
                        System.out.println("Dice1: " + roll1);
                        System.out.println("Dice2: " + roll2);
                        System.out.println("Total: " + rollTotal);

                        // Did you win?
                        if (rollTotal == points) {
                            System.out.println("You matched your point. You WIN!");
                            reRoll = false;
                        } else {
                            if (rollTotal == 7) {
                                System.out.println("You rolled a 7. You LOSE!");
                                reRoll = false;
                            }
                        }
                    }
                }
            }
            System.out.println("Game Over!");
            System.out.println("Wanna play again? (Y/n)");
            String playAgain = scan.nextLine();
            if (playAgain.equals("")) {

                // Let an empty string pass

            } else {
                if (playAgain.equals("n")) {
                    break;
                }
            }
        }
        System.out.println("Thanks for playing!");
        scan.close();
    }
}
