package server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataBase {
    List<String> listOfData = new ArrayList<>(Collections.nCopies(100, ""));

    void set (int cell, String input) {
        int index = num - 1;

        if (index >= 0 && index <= 99) {
            listOfData.set(index, input);
            System.out.println("OK");
        } else {
            System.out.println("ERROR");
        }
    }

    void get (int cell) {
        int index = cell - 1;

        if (index >= 0 && index <= 99 ) {
            listOfData.set(index, input);
            System.out.println("OK");
        } else {
            System.out.println("ERROR");
        }
    }

    private Boolean cellIsEmpty() {

    }

}
