package server.command;

import server.DataBase;

public class SetCell implements Command {
    private final DataBase db;

    SetCell(DataBase db) {
        this.db = db;
    }

    @Override
    public String execute(Object... args) {
        return db.set((int)args[0], (String)args[1]);
    }
}

