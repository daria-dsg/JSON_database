package server.command;

import server.database.DataBase;

public class GetCommand implements Command {

    private String key;
    private String result;

    public GetCommand (String key) {
        this.key = key;
    }

    public String getResult() {
        return result;
    }

    @Override
    public void execute() {
        result = DataBase.getInstance().get(key);
    }
}
