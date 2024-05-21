package server.command;

import server.database.DataBase;

public class GetCell implements Command {
    private final DataBase db;

    public GetCell(DataBase db) {
        this.db = db;
    }

    @Override
    public String execute(Object... args) {
        return db.get((int)args[0]);
    }
}
