package server.command;

import server.database.DataBase;

public class DeleteCommand implements Command {

    private String key;

    public DeleteCommand (String key) {
        this.key = key;
    }

    @Override
    public void execute() {
        DataBase.getInstance().delete(key);
    }
}
