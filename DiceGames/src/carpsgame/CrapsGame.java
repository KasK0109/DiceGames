package carpsgame;

import java.sql.SQLOutput;
import java.util.Scanner;

public class CrapsGame {

    private int wonGames = 0;
    private int lostGames = 0;
    /**
     * Simulates playing one game of craps.
     */
    public void play() {
        // TODO
        Scanner scanner = new Scanner(System.in);
        DiceThrower thrower = new DiceThrower();

        int points = 0;
        int comeOutRoll = 0;
        int roll = 0;


        System.out.println("Press [Enter] to play");
        scanner.nextLine();

        while (true) {
            thrower.roll();
            System.out.println(thrower.rollDescription());
            comeOutRoll = thrower.sum();
            System.out.println("Come out roll: " + comeOutRoll);
            if (comeOutRoll == 7 || comeOutRoll == 11) {
                printGameWon();
                break;
            } else {
                if (comeOutRoll == 2 || comeOutRoll == 3 || comeOutRoll == 12) {
                    printGameLost();
                    break;
                } else {
                    points = comeOutRoll;

                    boolean reRoll = true;

                    while (reRoll) {
                        System.out.println("Press [Enter] to roll again");
                        scanner.nextLine();
                        thrower.roll();
                        System.out.println(thrower.rollDescription());
                        roll = thrower.sum();
                        System.out.println("Your points: " + points);
                        System.out.println("New roll: " + roll);

                        if (points == roll) {
                            printGameWon();
                            reRoll = false;
                        } else {
                            if (roll == 7) {
                                printGameLost();
                                reRoll = false;
                            }
                        }
                    }
                }
            }
            System.out.println("Do you want to play again? (Y/n)");
            String playAgain = scanner.nextLine();
            if (playAgain.equals("")) {



            } else {
                if (playAgain.equals("n")) {
                    break;
                }

            }
        }
    }

    /**
     * Prints a 'You have won' message.
     */
    public void printGameWon() {
        // TODO
        System.out.println("You win!");
        wonGames++;
    }

    /**
     * Prints a 'You have lost' message.
     */
    public void printGameLost() {
        // TODO
        System.out.println("You lost!");
        lostGames++;
    }

    public int getWonGames() {
        return wonGames;
    }

    public int getLostGames() {
        return lostGames;
    }

    /**
     * Prints the rules of craps.
     */
    public void printRules() {
        // TODO
        System.out.println("================================================================================");
        System.out.println("Throw a pair of dice.");
        System.out.println("If you roll a 7 or 11,  you win!");
        System.out.println("If you roll a 2, 3 or 12, you lose!");
        System.out.println("If you roll something in between, your points will be set to your come out roll.");
        System.out.println("Roll again, if you roll the same number as your points, you win!");
        System.out.println("Else if you roll a 7, you lose!");
        System.out.println("================================================================================");
    }

}

