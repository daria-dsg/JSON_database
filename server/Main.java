package server;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataBase dataBase = new DataBase();

        String command = null;
        int cellNumber = 0;
        String text = null;

        while (scanner.hasNext()) {
            command = scanner.next();
            cellNumber = scanner.nextInt();

            if (scanner.hasNext()) { text = scanner.nextLine(); }

            if (scanner.next().equalsIgnoreCase("q")) break;
        }


        switch (Objects.requireNonNull(command)) {
            case "set" :
                dataBase.set(cellNumber, text);
                break;
            case "get" :
                dataBase.get(cellNumber);
                break;
        }
    }
}
