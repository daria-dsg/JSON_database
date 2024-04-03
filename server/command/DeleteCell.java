package server.command;

import server.DataBase;
import server.command.Command;

public class DeleteCell implements Command {
    private DataBase db;

    DeleteCell(DataBase db) {
        this.db = db;
    }

    @Override
    public String execute(Object... args) {
        return db.delete((int)args[0]);
    }
}
