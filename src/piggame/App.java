package piggame;


import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        // Scanner for user input
        Scanner scan = new Scanner(System.in);

        // A players score during their turn.
        int turnScore = 0;

        // The total score of player 1
        int p1TotalScore = 0;

        // The total score of player 2
        int p2TotalScore = 0;

        // Input from user if they wish to roll again
        String again = "";

        // Input from user if they want to take their turn
        String wantsToPlay = "";

        // Input from user if they want to start a new game
        String newGame = "";

        // Dice constructor creates a dice.
        Dice die = new Dice();

        // UI
        System.out.println("Welcome to the game of Pigs!");
        System.out.println("Do you want to start a new game? (y/n)");
        newGame = scan.next();

        // If the user doesn't want to start a new game the code breaks and exits here.
        // Else it continues
        if (newGame.charAt(0) == 'n') {
            System.out.println("Sad :( you didn't to play!");
        } else {

            // Player constructors for two players.
            Player player1 = new Player();
            Player player2 = new Player();

            // Ensures the game doesn't continue if a players total score exceeds 100
            while (p1TotalScore <= 100 && p2TotalScore <= 100) {
                System.out.println("Player 1, Do you wish to play? (y/n)");
                wantsToPlay = scan.next();
                if (wantsToPlay.charAt(0) == 'n') {

                    // Empty body - program should just exit

                } else {
                    while (true) {
                        die.roll();
                        int side = die.roll();
                        System.out.println("You rolled a: " + side);
                        if (side != 1) {
                            turnScore += side;
                        } else {
                            System.out.println("You rolled a one! Turn over.");
                            turnScore = 0;
                            break;
                        }

                        System.out.println("Turn score: " + turnScore);
                        System.out.println("Do you want to roll again? (y/n)");
                        again = scan.next();
                        if (again.charAt(0) == 'n') {
                            p1TotalScore += turnScore;
                            if (p1TotalScore >= 100) {
                                System.out.println(player1.getName() + " reached 100 points and WINS!");
                                break;
                            }
                            turnScore = 0;
                            System.out.println("You ended your turn, your total score so far is: " + p1TotalScore);
                            break;
                        }

                    }
                }
                System.out.println("Player 2, do you want to play? (y/n)");
                wantsToPlay = scan.next();
                if (wantsToPlay.charAt(0) == 'n') {

                    // Program exits - needs to go to player 1 again.

                } else {
                    while (true) {
                        die.roll();
                        int side = die.roll();
                        System.out.println("You rolled a: " + side);
                        if (side != 1) {
                            turnScore += side;
                        } else {
                            System.out.println("You rolled a one! Turn over.");
                            turnScore = 0;
                            break;
                        }

                        System.out.println("Turn score: " + turnScore);
                        System.out.println("Do you want to roll again? (y/n)");
                        again = scan.next();
                        if (again.charAt(0) == 'n') {
                            p2TotalScore += turnScore;
                            if (p2TotalScore >= 100) {
                                System.out.println(player2.getName() + " reached 100 and WINS!");
                                break;
                            }
                            turnScore = 0;
                            System.out.println("You ended your turn, your total score so far is: " + p2TotalScore);
                            break;
                        }
                    }
                }
            }
        }
    }
}
