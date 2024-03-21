package server;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataBase dataBase = new DataBase();

        String command = scanner.next();
        int cellNumber = 0;
        String text = null;

        if (scanner.hasNext()) {
            cellNumber = scanner.nextInt();
            if (scanner.hasNext()) {
                text = scanner.next();
            }
        }

        switch (command) {
            case "set" :
                dataBase.set(cellNumber, text);
                break;
            case "get" :
                dataBase.get(cellNumber);
                break;
        }
    }
}
