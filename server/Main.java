package server;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataBase dataBase = new DataBase();

        String command = scanner.next();
        int num = scanner.nextInt();
        String input = scanner.next();

        switch (command) {
            case "set" : dataBase.set(num, input);
        }

    }
}
