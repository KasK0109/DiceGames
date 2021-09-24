package piggame2;

import java.util.Scanner;

public class PigGame {

    private int turnPoints;

    private String rollAgain = "";

    Scanner scanner = new Scanner(System.in);
    DiceThrower thrower = new DiceThrower();

    public void play() {

        turnPoints = 0;

        System.out.println("Welcome to the game of Pigs!");

        Player player1 = new Player();
        Player player2 = new Player();

        System.out.println(player1.getName());
        System.out.println(player2.getName());

        while (player1.getTotalPoints() <= 100 && player2.getTotalPoints() <= 100) {

            System.out.println(player1.getName() + " do you want to roll the die? (y/n)");
            rollAgain = scanner.next();
            if (rollAgain.equalsIgnoreCase("n")) {

            } else {
                rollDie();
                if (thrower.sum() == 1) {
                    System.out.println("You rolled a 1, turn over");
                } else {
                    System.out.println("You rolled a: " + thrower.rollDescription());
                    System.out.println("Turn points: " + turnPoints);


                    player1.setTotalPoints(turnPoints);
                    System.out.println(player1.getName() + " total points: " + player1.getTotalPoints());
                }
            }
            player1.setTotalPoints(turnPoints);
            System.out.println(player1.getName() + " total points: " + player1.getTotalPoints());
        }
    }

    public void rollDie() {
        thrower.roll();
        System.out.println(thrower.rollDescription());
        turnPoints += thrower.sum();
    }
}
