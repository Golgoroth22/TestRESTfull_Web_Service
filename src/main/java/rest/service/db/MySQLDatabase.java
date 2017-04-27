package rest.service.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Валентин Фалин on 25.04.2017.
 */
public class MySQLDatabase extends Database {
    private static final String url = "jdbc:mysql://localhost:3306/gb?useSSL=false";
    private static final String user = "root";
    private static final String password = "root";

    private Connection connection;

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public void connect() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
