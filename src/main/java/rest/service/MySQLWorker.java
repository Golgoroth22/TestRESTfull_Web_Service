package rest.service;

import java.sql.*;

/**
 * Created by Валентин Фалин on 14.04.2017.
 */
public class MySQLWorker {
    private static final String url = "jdbc:mysql://localhost:3306/world?useSSL=false";
    private static final String user = "root";
    private static final String password = "1qazxsw2";

    private static Connection conn;
    private static Statement stmt;
    private static ResultSet rs;

    public String get(int id) {
        String querry = "SELECT * FROM city WHERE ID = " + id + ";";

        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(querry);
            rs.next();
            return rs.getString(2);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return "NULL";
    }

    public static void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
