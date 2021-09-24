package piggame2;

import java.util.Scanner;

public class Player {

    Scanner scanner = new Scanner(System.in);

    private String name = "";

    private int totalPoints;

    public Player() {
        System.out.print("Enter a name: ");
        name = scanner.next();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getTotalPoints() {
        return totalPoints;
    }
}
