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

    public void delete (String key) {
        if (database.has(key)) {
            database.remove(key);
        } else {
            throw new NoSuchKeyException();
        }
    }
}
