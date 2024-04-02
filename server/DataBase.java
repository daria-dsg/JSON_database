package server;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class DataBase {
    private final List<String> listOfData = new ArrayList<>(Collections.nCopies(999, ""));

    protected void run(String input) {

        Scanner inputScanner = new Scanner(input);

        // Read the first and the second token
        String command = inputScanner.next();
        int cellNumber = inputScanner.nextInt();

        switch (Objects.requireNonNull(command)) {
            case "set" :
                String text = inputScanner.nextLine().trim();
                set(cellNumber, text);
                break;
            case "get" :
                get(cellNumber);
                break;
            case "delete":
                delete(cellNumber);
                break;
        }

        inputScanner.close();
    }

    private void set (int cell, String input) {
        int index = cell - 1;

        if (isIndexValid(index)) {
            listOfData.set(index, input);
            System.out.println("OK");
        } else {
            System.out.println("ERROR");
        }
    }

    private void get (int cell) {
        int index = cell - 1;

        if (isIndexValid(index)) {
            String data = listOfData.get(index);
            if ("".equals(data)) {
                System.out.println("ERROR");
            } else {
                System.out.println(data);
            }
        } else {
            System.out.println("ERROR");
        }
    }

    private void delete (int cell) {
        int index = cell - 1;

        if (isIndexValid(index)) {
            String data = listOfData.get(index);
            if (!"".equals(data)) {
                listOfData.remove(index);
            }
        } else {
            System.out.println("ERROR");
        }
    }

    private boolean isIndexValid(int index) {
        return index >= 0 && index < 99;
    }
}
