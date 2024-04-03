package server.command;

import server.DataBase;

public class DeleteCell implements Command {
    private final DataBase db;

    public DeleteCell(DataBase db) {
        this.db = db;
    }

    @Override
    public String execute(Object... args) {
        return db.delete((int)args[0]);
    }
}
