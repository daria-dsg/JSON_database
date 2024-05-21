package server.command;

import server.database.DataBase;

public class DeleteCommand implements Command {

    private String key;
    private String result;

    public DeleteCommand (String key) {
        this.key = key;
    }

    public String getResult() {
        return result;
    }

    @Override
    public void execute() {
        result = DataBase.getInstance().delete(key);
    }
}
