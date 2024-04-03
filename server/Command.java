package server;

public interface Command {
    public void execute(int indexOfCell, String... args);
}
