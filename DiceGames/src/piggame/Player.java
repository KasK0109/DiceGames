package piggame;

import java.util.Scanner;

public class Player {

    Scanner scan = new Scanner(System.in);

    private String name = "";

    public Player() {
        System.out.print("Enter a player name: ");
        String newName = "";
        newName = scan.next();
        this.name = newName;
    }

    public String getName() {
        return this.name;
    }
}
