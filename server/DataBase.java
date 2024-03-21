package server;

import java.util.*;

public class DataBase {
    private List<String> listOfData = new ArrayList<>(Collections.nCopies(100, ""));

    protected void run(String input) {
        String inputLine = input;

        Scanner inputScanner = new Scanner(inputLine);

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
            if ("".equals(data)) {
                return;
            } else {
                listOfData.remove(index);
            }
        } else {
            System.out.println("ERROR");
        }
    }

    private boolean isIndexValid(int index) {
        return (index < 0 || index >= 99) ? false : true;
    }
}
