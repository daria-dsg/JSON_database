package server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataBase {
    List<String> listOfData = new ArrayList<>(Collections.nCopies(100, ""));

    void set (int cell, String input) {
        int index = cell - 1;

        if (isIndexValid(index)) {
            listOfData.set(index, input);
            System.out.println("OK");
        } else {
            System.out.println("ERROR");
        }
    }

    void get (int cell) {
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

    void delete (int cell) {
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
