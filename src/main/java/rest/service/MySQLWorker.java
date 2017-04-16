package rest.service;

import java.sql.*;

/**
 * Created by Валентин Фалин on 14.04.2017.
 */
public class MySQLWorker {
    private static final String url = "jdbc:mysql://localhost:3306/gb-trainee?useSSL=false";
    private static final String user = "root";
    private static final String password = "1qazxsw2";

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    /**
     * Метод для получения всех упоминаний одной конкретной личности(из таблицы persons)
     * из таблицы person_page_rank по id.
     */
    public int getPersonPageRank(int id) {
        String querry = "SELECT * FROM person_page_rank WHERE person_id = ?;";

        try {
            connection = DriverManager.getConnection(url, user, password);
            preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            int result = 0;
            while (resultSet.next()) {
                result += resultSet.getInt(3);
            }
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return 0;
    }

    /**
     * Метод для добавления личности в таблицу persons.
     */
    public boolean addPerson(String name) {
        String querry = "INSERT INTO persons (name) VALUES (?);";

        try {
            connection = DriverManager.getConnection(url, user, password);
            preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            close();
        }
        return true;
    }

    /**
     * Метод для получения конкретной личности из таблицы persons по id.
     */
    public String getPerson(int id) {
        String querry = "SELECT * FROM persons WHERE id = ?;";

        try {
            connection = DriverManager.getConnection(url, user, password);
            preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            return resultSet.getString(2);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return "NULL";
    }

    /**
     * Метод для закрытия соединений с БД.
     */
    public static void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
