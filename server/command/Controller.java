package server.command;

public class Controller {
    public void executeCommand(Command command) {
        command.execute();
    }
}
