package org.example.dao;

import org.example.dto.PersonFilter;
import org.example.models.Person;
import org.example.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonDaoImpl implements PersonDao{
    private static final PersonDao personDao = new PersonDaoImpl();

    private static final String CREATE_TABLE = """
            CREATE TABLE IF NOT EXISTS person (
            id SERIAL primary key,
            firstName varchar(30) not null,
            lastName varchar(30) not null,
            email varchar(30) not null,
            number INT not null,
            money DOUBLE PRECISION not null 
            )
            """;
    private static final String DELETE_TABLE = """
            DROP TABLE IF EXIST person;
            """;
    private static final String CLEAN_TABLE = """
            TRUNCATE TABLE person;
            """;
    private static final String DELETE_SQL = """
            DELETE FROM person
            WHERE id = ?
            """;
    private static final String FIND_ALL = """
            SELECT id,
                firstName,
                lastName,
                email,
                number,
                money
            FROM person
            """;
    private static final String FIND_BY_ID = FIND_ALL + """
            WHERE id = ?
            """;
    private static final String SAVE_SQL = """
            INSERT INTO person (firstName, lastName, email, number, money) 
            VALUES (?, ?, ?, ?, ?)
            """;
    private static final String UPDATE_SQL = """
            UPDATE person 
            SET firstName = ?,
                lastName = ?,
                email = ?,
                number = ?,
                money = ?
            WHERE id = ?
            """;
    private PersonDaoImpl() {

    }
    public static PersonDao getPersonDao() {
        return personDao;
    }

    @Override
    public boolean createTable() {
        try (Connection connection = ConnectionManager.open();
             Statement statement = connection.createStatement()) {
            return statement.execute(CREATE_TABLE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean dropTable() {
        try (Connection connection = ConnectionManager.open();
             Statement statement = connection.createStatement()) {
            return statement.execute(DELETE_TABLE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void cleanTable() {
        try (Connection connection = ConnectionManager.open();
             Statement statement = connection.createStatement()) {
            statement.execute(CLEAN_TABLE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Person> findById(int id) {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Person person = null;

            if (resultSet.next()) {
                person = buildPerson(resultSet);
            }

            return Optional.ofNullable(person);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(int id) {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() >= 1 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(String name) {
        return false;
    }

    @Override
    public List<Person> findAll() {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Person> persons = new ArrayList<>();

            while (resultSet.next()) {
                persons.add(buildPerson(resultSet));
            }

            return persons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Person> findAll(PersonFilter personFilter) {
        return null;
    }

    @Override
    public void update(Person person) {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setString(3, person.getEmail());
            preparedStatement.setInt(4, person.getNumber());
            preparedStatement.setDouble(5, person.getMoney());
            preparedStatement.setInt(6, person.getId());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Person save(Person person) {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL,
                     Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setString(3, person.getEmail());
            preparedStatement.setInt(4, person.getNumber());
            preparedStatement.setDouble(5, person.getMoney());
            preparedStatement.setInt(6, person.getId());

            preparedStatement.execute();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                person.setId(generatedKeys.getInt("id"));
            }

            return person;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Person buildPerson(ResultSet resultSet) throws SQLException {
        return new Person(
                resultSet.getInt("id"),
                resultSet.getString("firstName"),
                resultSet.getString("lastName"),
                resultSet.getString("email"),
                resultSet.getInt("number"),
                resultSet.getDouble("money")
        );
    }
}
