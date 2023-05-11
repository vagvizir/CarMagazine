package org.example.dao;

import org.example.models.Person;
import org.example.util.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoJdbcImpl implements PersonDaoJdbc {
    @Override
    public void createTable() {
        try (Statement statement = ConnectionManager.open().createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS persons (id BIGINT PRIMARY KEY AUTO_INCREMENT, " +
                    "firstname VARCHAR(45), lastname VARCHAR(45), email VARCHAR(45), number INT(12), money DOUBLE)");
            System.out.println("таблица person создана");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void dropTable() {
        try (Statement statement = ConnectionManager.open().createStatement()) {
            statement.execute("DROP TABLE IF EXISTS persons");
            System.out.println("таблица person удалена");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void cleanTable() {

    }

    @Override
    public Person getPerson(int id) {
        try (Statement statement = ConnectionManager.open().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM persons WHERE id = " + id);
            resultSet.next();

            Person person = new Person();
            person.setFirstName(resultSet.getString(1));
            person.setLastName(resultSet.getString(2));
            person.setEmail(resultSet.getString(3));
            person.setNumber(resultSet.getInt(4));
            person.setMoney((resultSet.getDouble(5)));
            return person;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletePerson(int id) {
        try (PreparedStatement statement = ConnectionManager.open().prepareStatement("DELETE " +
                "FROM persons WHERE id = ?")) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletePerson(String name) {

    }

    @Override
    public List<Person> getAllPersons() {
        try (Statement statement = ConnectionManager.open().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM persons");
            List<Person> result = new ArrayList<>();

            while (resultSet.next()) {
                Person person = new Person();

                person.setFirstName(resultSet.getString(1));
                person.setLastName(resultSet.getString(2));
                person.setEmail(resultSet.getString(3));
                person.setNumber(resultSet.getInt(4));
                person.setMoney(resultSet.getDouble(5));

                result.add(person);

            }

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void savePerson(Person person) {
        try (PreparedStatement statement = ConnectionManager.open().prepareStatement
                ("INSERT INTO persons (firstname, lastname, email, number, money) VALUES (?, ?, ?, ?, ?)")) {
            statement.setString(1, person.getFirstName());
            statement.setString(2, person.getLastName());
            statement.setString(3, person.getEmail());
            statement.setInt(4, person.getNumber());
            statement.setDouble(5, person.getMoney());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
