package server.database;

import com.google.gson.JsonObject;
import server.exception.NoSuchKeyException;

public class DataBase {

    private static DataBase instance;
    private final JsonObject database = new JsonObject();
    private DataBase() {}

    // Static method to get instance of database
    public static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }

    public void set(String key, String value) {
        database.addProperty(key, value);
    }

    public String get(String key) {
        if (database.has(key)) {
            return String.valueOf(database.get(key));
        } else {
            throw new NoSuchKeyException();
        }
    }

    public void delete(String key) {
        if (database.has(key)) {
            database.remove(key);
        } else {
            throw new NoSuchKeyException();
        }
    }
}
