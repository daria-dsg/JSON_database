package server;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class DataBase {
    private final List<String> listOfData = new ArrayList<>(Collections.nCopies(999, ""));

    protected  String set (int cell, String input) {
        int index = cell - 1;

        if (isIndexValid(index)) {
            listOfData.set(index, input);
            return "OK";
        } else {
            return "ERROR";
        }
    }

    protected String get (int cell) {
        int index = cell - 1;

        if (isIndexValid(index)) {
            String data = listOfData.get(index);
            if ("".equals(data)) {
                return "ERROR";
            } else {
                return data;
            }
        } else {
            return "ERROR";
        }
    }

    protected String delete (int cell) {
        int index = cell - 1;

        if (isIndexValid(index)) {
            String data = listOfData.get(index);
            if (!"".equals(data)) {
                listOfData.remove(index);
                return "OK";
            }
        } else {
            return "ERROR";
        }

        return "ERROR";
    }

    private boolean isIndexValid(int index) {
        return index >= 0 && index < 9999;
    }
}
