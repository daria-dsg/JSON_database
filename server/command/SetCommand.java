package server.command;

import server.database.DataBase;

public class SetCommand implements Command {

    private String key;
    private String value;

    public SetCommand (String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public void execute() {
        DataBase.getInstance().set(key, value);
    }
}