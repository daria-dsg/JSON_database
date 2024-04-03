package server;

public class GetCell implements Command{
    private DataBase db;

    GetCell(DataBase db) {
        this.db = db;
    }

    @Override
    public String execute(int indexOfCell) {
        return db.get(indexOfCell);
    }
}
