package server;

import com.google.gson.JsonObject;
import server.exceptions.NoSuchKeyException;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class DataBase {
    private static JsonObject database = null;

    // Static method to get instance of database
    public static JsonObject getInstance() {
        if (database == null) {
            database = new JsonObject();
        }
        return database;
    }

    public void set (String key, String value) {
        database.addProperty(key, value);
    }

    public void get (String key) {
        if (database.has(key)) {
            database.get(key);
        } else {
            throw new NoSuchKeyException();
        }
    }


//    public String get (int cell) {
//        int index = cell - 1;
//
//        if (isIndexValid(index)) {
//            String data = cells.get(index);
//            if ("".equals(data)) {
//                return "ERROR";
//            } else {
//                return data;
//            }
//        } else {
//            return "ERROR";
//        }
//    }
//
//    public String delete (int cell) {
//        int index = cell - 1;
//
//        if (isIndexValid(index)) {
//            String data = cells.get(index);
//            if (!"".equals(data)) {
//                cells.remove(index);
//                return "OK";
//            }
//        } else {
//            return "ERROR";
//        }
//
//        cells.set(index, "");
//        return "OK";
//    }
//
//    private boolean isIndexValid(int index) {
//        return index >= 0 && index < 999;
//    }
}
