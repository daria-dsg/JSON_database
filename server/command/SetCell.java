package server;

public class SetCell implements Command{
    private DataBase db;

    SetCell(DataBase db) {
        this.db = db;
    }

    @Override
    public String execute(int indexOfCell, String message) {
        return db.set(indexOfCell, message);
    }
}

