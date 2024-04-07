package server;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class DataBase {
    private final List<String> cells;
    private static DataBase instance = null;

    //Private constructor to prevent instantiation outside
    private DataBase(int size) {
        cells = new ArrayList<>(Collections.nCopies(size - 1, ""));
    }

    // Static method to get instance of database
    public static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase(1000);
        }

        return instance;
    }

    public String set (int cell, String input) {
        int index = cell - 1;

        if (isIndexValid(index)) {
            cells.set(index, input);
            return "OK";
        } else {
            return "ERROR";
        }
    }

    public String get (int cell) {
        int index = cell - 1;

        if (isIndexValid(index)) {
            String data = cells.get(index);
            if ("".equals(data)) {
                return "ERROR";
            } else {
                return data;
            }
        } else {
            return "ERROR";
        }
    }

    public String delete (int cell) {
        int index = cell - 1;

        if (isIndexValid(index)) {
            String data = cells.get(index);
            if (!"".equals(data)) {
                cells.remove(index);
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
