package server.command;

public class Controller {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public String executeCommand(Object... args) {
        return command.execute(args);
    }
}
