package rest.service;

import java.sql.*;

/**
 * Created by Валентин Фалин on 14.04.2017.
 */
public class MySQLWorker {
    private static final String url = "jdbc:mysql://188.166.160.168/gb?useSSL=false";
    private static final String user = "gb";
    private static final String password = " 1qasde32w";

    private static Connection connection;
    private static PreparedStatement preparedStatement;

    /**
     * Метод для добавления личности в таблицу persons.
     */
    public boolean addIntoTablePersons(String name) {
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
     * Метод для редактирования конкретной личности из таблицы persons по id.
     */
    public boolean updateTablePersons(int id, String value) {
        String querry = "UPDATE persons SET name = ? WHERE id = ?;";

        try {
            connection = DriverManager.getConnection(url, user, password);
            preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setString(1, value);
            preparedStatement.setInt(2, id);
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
     * Метод для удаления позиции из таблицы по заданному id.
     */
    public boolean deleteFromTable(String table, int id) {
        String querry = "DELETE FROM %s WHERE id = ?;";

        try {
            connection = DriverManager.getConnection(url, user, password);
            preparedStatement = connection.prepareStatement(String.format(querry, table));
            preparedStatement.setInt(1, id);
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
     * Метод для добавления нового значения в таблицу sites.
     */
    public boolean addIntoTableSites(String name, String base_url) {
        String querry = "INSERT INTO sites (name, base_url) VALUES (?, ?);";

        try {
            connection = DriverManager.getConnection(url, user, password);
            preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, base_url);
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
     * Метод для редактирования значений в таблице sites по заданному id.
     */
    public boolean updateTableSites(int id, String name, String base_url) {
        String querry = "UPDATE sites SET name = ?, base_url = ? WHERE id = ?;";

        try {
            connection = DriverManager.getConnection(url, user, password);
            preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, base_url);
            preparedStatement.setInt(3, id);
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
     * Метод для добавления нового значения в таблицу keywords.
     */
    public boolean addIntoTableKeywords(String name, int person_id) {
        String querry = "INSERT INTO keywords (name, person_id) VALUES (?, ?);";

        try {
            connection = DriverManager.getConnection(url, user, password);
            preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, person_id);
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
     * Метод для редактирования значений в таблице keywords по заданному id.
     */
    public boolean updateTableKeywords(int id, String name, int person_id) {
        String querry = "UPDATE keywords SET name = ?, person_id = ? WHERE id = ?;";

        try {
            connection = DriverManager.getConnection(url, user, password);
            preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, person_id);
            preparedStatement.setInt(3, id);
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
