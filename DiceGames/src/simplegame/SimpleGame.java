package simplegame;

import java.util.Scanner;

public class SimpleGame {

    /**
     * Simulates playing one game of Simple.
     */
    public void play() {
        Scanner scanner = new Scanner(System.in);
        DiceThrower thrower = new DiceThrower();

        boolean finished = false;
        while (!finished) {
            // TODO: Roll dice, print roll description.

            thrower.roll();
            System.out.println(thrower.rollDescription());


            System.out.println("Roll again? (Y/n) ");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("n")) {
                finished = true;
            }
        }
        scanner.close();

        thrower.setAverageSum();

        System.out.print("\nResults:\n");
        System.out.print("---------\n");
        // TODO: Print all the results:
        // roll count, total of all face values, average sum in one roll,
        // count of face value 6, count of same face value on both dice,
        // max sum in one roll.
        // Use the method: System.out.printf().
        System.out.println("=======================================");
        System.out.printf("Roll count: %d",thrower.getRollCount());
        System.out.println();
        System.out.printf("Total face value: %d", thrower.getTotalFaceValue());
        System.out.println();
        System.out.printf("Average sum in one roll: %f",thrower.getAverageSum());
        System.out.println();
        System.out.printf("Number of sixes: %d",thrower.getNumberOfSixes());
        System.out.println();
        System.out.printf("Number of duplicates: %d", thrower.getDuplicates());
        System.out.println();
        System.out.printf("Max sum: %d", thrower.getMaxSum());
        System.out.println();
        System.out.println("=======================================");


    }

    /**
     * Prints the rules of Simple.
     */
    public void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of Simple:");
        System.out.println("The player throws the 2 dice as long as he/she wants.");
        System.out.println("=====================================================");
    }

}

