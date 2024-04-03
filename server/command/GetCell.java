package server.command;

import server.DataBase;
import server.command.Command;

public class GetCell implements Command {
    private DataBase db;

    GetCell(DataBase db) {
        this.db = db;
    }

    @Override
    public String execute(Object... args) {
        return db.get((int)args[0]);
    }
}
