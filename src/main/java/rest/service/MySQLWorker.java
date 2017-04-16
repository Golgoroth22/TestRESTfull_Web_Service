package rest.service;

import java.sql.*;

/**
 * Created by Валентин Фалин on 14.04.2017.
 */
public class MySQLWorker {
    private static final String url = "jdbc:mysql://localhost:3306/gb-trainee?useSSL=false";
    private static final String user = "root";
    private static final String password = "1qazxsw2";

    private static Connection conn;
    private static PreparedStatement prpdstmt;
    private static ResultSet rs;

    //Метод для получения одного значения из таблицы persons по id
    public String get(int id) {
        String querry = "SELECT * FROM persons WHERE ID = ?;";

        try {
            conn = DriverManager.getConnection(url, user, password);
            prpdstmt = conn.prepareStatement(querry);
            prpdstmt.setInt(1, id);
            rs = prpdstmt.executeQuery();
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
            prpdstmt.close();
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
