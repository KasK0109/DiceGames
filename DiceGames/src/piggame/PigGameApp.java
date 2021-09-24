package piggame;

import java.util.Scanner;

public class PigGameApp {
    public static void main(String[] args) {

        // Scanner for user input
        Scanner scan = new Scanner(System.in);

        // A players score during their turn.
        int turnScore = 0;

        // The total score of player 1
        int p1TotalScore = 0;

        // The total score of player 2
        int p2TotalScore = 0;

        int endGoal = 100;

        // Input from user if they wish to roll again
        String again = "";

        // Input from user if they want to take their turn
        String wantsToPlay = "";

        // Input from user if they want to start a new game
        String newGame = "";

        // Change the end goal of the game from 100 to another integer
        String changeEndGoal = "";

        // Asks if the players wants to play with 1 or 2 die
        String oneOrTwoDie = "";

        // While loop condition to make sure the program exits if someone won
        boolean someoneWon = false;

        // Dice constructor creates a dice.
        Die die1 = new Die();
        Die die2 = new Die();

        // UI
        System.out.println("Welcome to the game of Pigs!");
        System.out.print("Do you want to start a new game? (y/n): ");
        newGame = scan.next();
        System.out.println();

        // Player constructors
        Player player1 = new Player();
        Player player2 = new Player();

        // If the user doesn't want to start a new game the code breaks and exits here.
        // Else it continues
        if (newGame.charAt(0) == 'n') {
            System.out.println("Sad :( you didn't want to play!");
        } else {

            // Asks if the user wants to change the end goal of the game
            System.out.print("The standard end goal is 100 points, do you wish to change that? (Y/n)");
            changeEndGoal = scan.next();
            System.out.println();
            if (changeEndGoal.equalsIgnoreCase("n")) {

            } else {

                // Changes the end goal of the game
                System.out.print("Enter a new end goal: ");
                endGoal = scan.nextInt();
            }

            // Asks if the players wants to play with 1 or 2 die
            System.out.println("Do you want to play with 1 die or 2 dice? (1/2)");
            oneOrTwoDie = scan.next();

            // If the players wants to play with one die runs this algorithm
            if (oneOrTwoDie.equals("1")) {

                // Ensures the game doesn't continue if a players total score exceeds 100
                while (p1TotalScore <= endGoal && p2TotalScore <= endGoal) {
                    System.out.println("Player 1, Do you wish to play? (y/n)");
                    wantsToPlay = scan.next();
                    if (wantsToPlay.charAt(0) == 'n') {

                        // Empty body - program should just exit

                    } else {
                        while (!someoneWon) {
                            die1.roll(); // Rolls the die
                            int side = die1.roll();
                            System.out.println("You rolled a: " + side); // Prints the die roll

                            if (side != 1) {
                                turnScore += side;
                            } else {
                                System.out.println("You rolled a one! Turn over."); // If the player rolls a 1 the program breaks
                                turnScore = 0;
                                break;
                            }

                            System.out.println("Turn score: " + turnScore);


                            System.out.println("Do you want to roll again? (y/n)"); // Asks the user if they want to roll again
                            again = scan.next();
                            if (again.charAt(0) == 'n') { // If they don't want to roll again the points they gained
                                p1TotalScore += turnScore;// during their turn is saved in their total points
                                if (p1TotalScore >= endGoal) {
                                    System.out.println(player1.getName() + " reached the end goal and WINS!");
                                    someoneWon = true; // Condition update if the total points of a player exceeds end goal
                                    break;
                                }
                                turnScore = 0;
                                System.out.println("You ended your turn, your total score so far is: " + p1TotalScore);
                                break; // Shows the user their total points
                            }
                        }
                    }
                    System.out.println("Player 2, do you want to play? (y/n)"); // Asks if the other player wants to take their turn
                    wantsToPlay = scan.next();
                    if (wantsToPlay.charAt(0) == 'n') {

                        // Program exits - needs to go to player 1 again.

                    } else {
                        while (!someoneWon) { // --''--
                            die1.roll();
                            int side = die1.roll();
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
                                if (p2TotalScore >= endGoal) {
                                    System.out.println(player2.getName() + " reached the end goal and WINS!");
                                    someoneWon = true;
                                    break;
                                }
                                turnScore = 0;
                                System.out.println("You ended your turn, your total score so far is: " + p2TotalScore);
                                break;
                            }
                        }
                    }
                }
            } else { // If the players wants to use 2 die this program executes

                while (p1TotalScore <= endGoal && p2TotalScore <= endGoal) {
                    System.out.println("Player 1, Do you wish to play? (y/n)");
                    wantsToPlay = scan.next();
                    if (wantsToPlay.charAt(0) == 'n') {

                        // Empty body - program should just exit

                    } else {
                        while (!someoneWon) {
                            die1.roll(); // Rolls the 2 dice
                            die2.roll();
                            int side1 = die1.roll();
                            int side2 = die2.roll();
                            System.out.println("You rolled a: " + side1 + " and a: " + side2); // Prints what the player rolled

                            if (side1 == side2 && (side1 != 1 && side2 != 1)) { // If the 2 sides are equal rolls automatically
                                System.out.println("You rolled a pair! Extra roll awarded!");
                                turnScore += (side1 + side2);
                            } else {
                                if (side1 != 1 && side2 != 1) { // If both sides are different and none are equal to one
                                    turnScore += (side1 + side2); // adds the sum of the two sides to the turn points
                                } else {
                                    if ((side1 == 1 && side2 != 1) || (side1 != 1 && side2 == 1)) { // If one side is 1 and other is not
                                        System.out.println("You rolled a one! Turn over."); // turnover
                                        turnScore = 0;
                                        break;
                                    } else {
                                        if (side1 == 1 && side2 == 1) { // If both sides are 1 the total points of the player is deleted
                                            System.out.println("You rolled a double 1, you lost all your points!");
                                            p1TotalScore = 0;
                                        }
                                        break;
                                    }
                                }

                                System.out.println("Turn score: " + turnScore);


                                System.out.println("Do you want to roll again? (y/n)"); // Asks if the player wants to roll again
                                again = scan.next();
                                if (again.charAt(0) == 'n') {
                                    p1TotalScore += turnScore;
                                    if (p1TotalScore >= endGoal) {
                                        System.out.println(player1.getName() + " reached the end goal and WINS!");
                                        someoneWon = true;
                                        break;
                                    }
                                    turnScore = 0;
                                    System.out.println("You ended your turn, your total score so far is: " + p1TotalScore);
                                    break;
                                }

                                if (p1TotalScore >= endGoal) {
                                    System.out.println(player1.getName() + " has reached the end goal and WON!");
                                    someoneWon = true;
                                    break;
                                }
                            }
                        }
                        System.out.println("Player 2, do you want to play? (y/n)");
                        wantsToPlay = scan.next();
                        if (wantsToPlay.charAt(0) == 'n') {

                            // Program exits - needs to go to player 1 again.

                        } else {
                            while (!someoneWon) {
                                die1.roll();
                                die2.roll();
                                int side1 = die1.roll();
                                int side2 = die2.roll();
                                System.out.println("You rolled a: " + side1 + " and a: " + side2);
                                if (side1 == side2 && !(side1 == 1)) {
                                    System.out.println("You rolled a pair! Extra roll awarded!");
                                    turnScore += (side1 + side2);
                                } else {
                                    if (side1 != 1 && side2 != 1) {
                                        turnScore += (side1 + side2);
                                    } else {
                                        if ((side1 == 1 && side2 != 1) || (side1 != 1 && side2 == 1)) {
                                            System.out.println("You rolled a one! Turn over.");
                                            turnScore = 0;
                                            break;
                                        } else {
                                            if (side1 == 1 && side2 == 1) {
                                                System.out.println("You rolled a double 1 and lost all your points!");
                                                p2TotalScore = 0;
                                                break;
                                            }
                                        }
                                        break;
                                    }

                                    System.out.println("Turn score: " + turnScore);


                                    System.out.println("Do you want to roll again? (y/n)");
                                    again = scan.next();
                                    if (again.charAt(0) == 'n') {
                                        p2TotalScore += turnScore;
                                        if (p2TotalScore >= endGoal) {
                                            System.out.println(player2.getName() + " reached the end goal and WINS!");
                                            someoneWon = true;
                                            break;
                                        }
                                        turnScore = 0;
                                        System.out.println("You ended your turn, your total score so far is: " + p2TotalScore);
                                        break;
                                    }
                                    if (p2TotalScore >= endGoal) {
                                        System.out.println(player2.getName() + " has reached the end goal and WON!");
                                        someoneWon = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

