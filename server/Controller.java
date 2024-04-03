package server;

import server.command.Command;

public class Controller {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand(Object... args) {
        command.execute(args);
    }
}
