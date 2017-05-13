package rest.service.api;

import rest.service.api.models.*;
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
     */
    public ArrayList<PersonWithCoincidences> getPersons(int site_id) {
        ArrayList<PersonWithCoincidences> result = new ArrayList();
        String query = "SELECT * FROM persons;";

        try {
            preparedStatement = database.getConnection().prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int coincidences = new MySQLWorker().getPersonCoincidences(site_id, resultSet.getInt(1));
                String name = resultSet.getString(2);
                result.add(new PersonWithCoincidences(name, coincidences));
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
        String query = "SELECT SUM(rank) FROM person_page_rank INNER JOIN " +
                "pages ON person_page_rank.page_id = pages.id WHERE site_id = ? AND person_id = ?;";

        try {
            preparedStatement = database.getConnection().prepareStatement(query);
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
    public boolean addIntoTablePersons(Person person) {
        String query = "INSERT INTO persons (name) VALUES (?);";

        try {
            preparedStatement = database.getConnection().prepareStatement(query);
            preparedStatement.setString(1, person.getName());
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
    public boolean updateTablePersons(Person person) {
        String query = "UPDATE persons SET name = ? WHERE id = ?;";

        try {
            preparedStatement = database.getConnection().prepareStatement(query);
            preparedStatement.setString(1, person.getName());
            preparedStatement.setInt(2, person.getId());
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
        String query = "DELETE FROM %s WHERE id = ?;";

        try {
            preparedStatement = database.getConnection().prepareStatement(String.format(query, table));
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
    public boolean addIntoTableSites(Site site) {
        String query = "INSERT INTO sites (name, base_url, open_tag, close_tag) VALUES (?, ?, ?, ?);";

        try {
            preparedStatement = database.getConnection().prepareStatement(query);
            preparedStatement.setString(1, site.getName());
            preparedStatement.setString(2, site.getBase_url());
            preparedStatement.setString(3, site.getOpen_tag());
            preparedStatement.setString(4, site.getClose_tag());
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
    public boolean updateTableSites(Site site) {
        String query = "UPDATE sites SET name = ?, base_url = ?, open_tag = ?, close_tag = ? WHERE id = ?;";

        try {
            preparedStatement = database.getConnection().prepareStatement(query);
            preparedStatement.setString(1, site.getName());
            preparedStatement.setString(2, site.getBase_url());
            preparedStatement.setString(3, site.getBase_url());
            preparedStatement.setString(4, site.getBase_url());
            preparedStatement.setInt(5, site.getId());
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
    public boolean addIntoTableKeywords(Keyword keyword) {
        String query = "INSERT INTO keywords (name, person_id) VALUES (?, ?);";

        try {
            preparedStatement = database.getConnection().prepareStatement(query);
            preparedStatement.setString(1, keyword.getName());
            preparedStatement.setInt(2, keyword.getPerson_id());
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
    public boolean updateTableKeywords(Keyword keyword) {
        String query = "UPDATE keywords SET name = ?, person_id = ? WHERE id = ?;";

        try {
            preparedStatement = database.getConnection().prepareStatement(query);
            preparedStatement.setString(1, keyword.getName());
            preparedStatement.setInt(2, keyword.getPerson_id());
            preparedStatement.setInt(3, keyword.getId());
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
        ArrayList<PersonCoincidencesByDate> result = new ArrayList();
        String query = "SELECT modified, SUM(rank) FROM pages INNER JOIN person_page_rank " +
                "ON pages.id = person_page_rank.page_id WHERE person_id = ? " +
                "AND modified >= ? AND modified <= ? AND site_id = ? GROUP BY modified;";

        try {
            preparedStatement = database.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, person_id);
            preparedStatement.setString(2, firstDate);
            preparedStatement.setString(3, lastDate);
            preparedStatement.setInt(4, site_id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int coincidences = resultSet.getInt(2);
                String date = resultSet.getString(1);
                result.add(new PersonCoincidencesByDate(date, coincidences));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.disconnect();
        }
        return result;
    }

    public ArrayList<?> getAllPersons() {
        ArrayList<Person> result = new ArrayList();
        String query = "SELECT id, name FROM persons;";

        try {
            preparedStatement = database.getConnection().prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                result.add(new Person(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.disconnect();
        }
        return result;
    }

    public ArrayList<?> getAllKeywordsByPersonId(int person_id) {
        ArrayList<Keyword> result = new ArrayList();
        String query = "SELECT * FROM keywords WHERE person_id = ?;";

        try {
            preparedStatement = database.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, person_id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                result.add(new Keyword(id, name, person_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.disconnect();
        }
        return result;
    }

    public ArrayList<?> getAllSites() {
        ArrayList<Site> result = new ArrayList();
        String query = "SELECT * FROM sites;";

        try {
            preparedStatement = database.getConnection().prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String base_url = resultSet.getString(3);
                String open_tag = resultSet.getString(4);
                String close_tag = resultSet.getString(5);
                result.add(new Site(id, name, base_url, open_tag, close_tag));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.disconnect();
        }
        return result;
    }

    public ArrayList<?> getAllKeywords() {
        ArrayList<Keyword> result = new ArrayList();
        String query = "SELECT * FROM keywords;";

        try {
            preparedStatement = database.getConnection().prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int person_id = resultSet.getInt(3);
                result.add(new Keyword(id, name, person_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.disconnect();
        }
        return result;
    }
}
