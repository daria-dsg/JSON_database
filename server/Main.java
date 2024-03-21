package server;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataBase dataBase = new DataBase();

        while (true) {
            System.out.println("Enter a command or type exit to quit (Press Enter to return token): ");
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) {
                break;
            } else {
                dataBase.run(input);
            }
        }

        scanner.close();
    }
}
