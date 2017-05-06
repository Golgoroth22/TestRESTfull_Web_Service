package rest.service.api;

import rest.service.api.model.CoincidencesByDate;
import rest.service.api.model.Person;
import rest.service.db.Database;
import rest.service.db.MySQLDatabase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Валентин Фалин on 14.04.2017.
 */
public class MySQLWorker {
    private Database database;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public MySQLWorker() {
        database = new MySQLDatabase();
        database.connect();
    }

    /**
     * Метод для получения всех личностей из таблицы persons.
     *
     * @param site_id
     */
    public ArrayList<Person> getPersons(int site_id) {
        ArrayList<Person> result = new ArrayList();
        String querry = "SELECT * FROM persons;";

        try {
            preparedStatement = database.getConnection().prepareStatement(querry);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int coincidences = new MySQLWorker().getPersonCoincidences(site_id, resultSet.getInt(1));
                String name = resultSet.getString(2);
                result.add(new Person(name, coincidences));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.disconnect();
        }
        return result;
    }

    /**
     * Метод для получения количества упоминаний конкретной личности из таблицы persons в таблице persons_page_rank.
     */
    public int getPersonCoincidences(int site_id, int person_id) {
        String querry = "SELECT SUM(rank) FROM person_page_rank INNER JOIN " +
                "pages ON person_page_rank.page_id = pages.id WHERE site_id = ? AND person_id = ?;";

        try {
            preparedStatement = database.getConnection().prepareStatement(querry);
            preparedStatement.setInt(1, site_id);
            preparedStatement.setInt(2, person_id);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.disconnect();
        }
        return 0;
    }

    /**
     * Метод для добавления личности в таблицу persons.
     */
    public boolean addIntoTablePersons(String name) {
        String querry = "INSERT INTO persons (name) VALUES (?);";

        try {
            preparedStatement = database.getConnection().prepareStatement(querry);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            database.disconnect();
        }
        return true;
    }

    /**
     * Метод для редактирования конкретной личности из таблицы persons по id.
     */
    public boolean updateTablePersons(int id, String value) {
        String querry = "UPDATE persons SET name = ? WHERE id = ?;";

        try {
            preparedStatement = database.getConnection().prepareStatement(querry);
            preparedStatement.setString(1, value);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            database.disconnect();
        }
        return true;
    }

    /**
     * Метод для удаления позиции из таблицы по заданному id.
     */
    public boolean deleteFromTable(String table, int id) {
        String querry = "DELETE FROM %s WHERE id = ?;";

        try {
            preparedStatement = database.getConnection().prepareStatement(String.format(querry, table));
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            database.disconnect();
        }
        return true;
    }

    /**
     * Метод для добавления нового значения в таблицу sites.
     */
    public boolean addIntoTableSites(String name, String base_url, String open_tag, String close_tag) {
        String querry = "INSERT INTO sites (name, base_url, open_tag, close_tag) VALUES (?, ?, ?, ?);";

        try {
            preparedStatement = database.getConnection().prepareStatement(querry);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, base_url);
            preparedStatement.setString(3, open_tag);
            preparedStatement.setString(4, close_tag);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            database.disconnect();
        }
        return true;
    }

    /**
     * Метод для редактирования значений в таблице sites по заданному id.
     */
    public boolean updateTableSites(int id, String name, String base_url) {
        String querry = "UPDATE sites SET name = ?, base_url = ? WHERE id = ?;";

        try {
            preparedStatement = database.getConnection().prepareStatement(querry);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, base_url);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            database.disconnect();
        }
        return true;
    }

    /**
     * Метод для добавления нового значения в таблицу keywords.
     */
    public boolean addIntoTableKeywords(String name, int person_id) {
        String querry = "INSERT INTO keywords (name, person_id) VALUES (?, ?);";

        try {
            preparedStatement = database.getConnection().prepareStatement(querry);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, person_id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            database.disconnect();
        }
        return true;
    }

    /**
     * Метод для редактирования значений в таблице keywords по заданному id.
     */
    public boolean updateTableKeywords(int id, String name, int person_id) {
        String querry = "UPDATE keywords SET name = ?, person_id = ? WHERE id = ?;";

        try {
            preparedStatement = database.getConnection().prepareStatement(querry);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, person_id);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            database.disconnect();
        }
        return true;
    }

    public ArrayList<?> getPersonByDate(int site_id, int person_id, String firstDate, String lastDate) {
        ArrayList<CoincidencesByDate> result = new ArrayList();
        String querry = "SELECT modified, rank FROM pages INNER JOIN person_page_rank " +
                "ON pages.id = person_page_rank.page_id WHERE person_id = ? " +
                "AND modified > ? AND modified < ? AND site_id = ?;";

        try {
            preparedStatement = database.getConnection().prepareStatement(querry);
            preparedStatement.setInt(1, person_id);
            preparedStatement.setString(2, firstDate);
            preparedStatement.setString(3, lastDate);
            preparedStatement.setInt(4, site_id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int coincidences = resultSet.getInt(2);
                String date = resultSet.getString(1);
                result.add(new CoincidencesByDate(date, coincidences));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.disconnect();
        }
        return result;
    }
}
