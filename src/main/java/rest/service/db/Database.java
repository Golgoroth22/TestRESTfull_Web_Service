package rest.service.db;

/**
 * Created by Валентин Фалин on 26.04.2017.
 */
public abstract class Database {
    public abstract void connect();

    public abstract void disconnect();

    public abstract java.sql.Connection getConnection();
}
