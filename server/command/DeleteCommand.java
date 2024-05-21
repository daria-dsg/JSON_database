package server.command;

public class DeleteCde implements Command {
    private final DataBase db;

    public DeleteCell(DataBase db) {
        this.db = db;
    }

    @Override
    public String execute(Object... args) {
        return db.delete((int)args[0]);
    }
}
