package org.example.dao;

import org.example.dto.BikeFilter;
import org.example.models.Bike;
import org.example.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BikeDaoImpl implements BikeDao {
    /**
     *  stack                  HEAP
     * bikeDao      ->      [bikeDao]
     * bikeDaoTwo   ->
     *
     *
     */
    private static final BikeDao bikeDao = new BikeDaoImpl();
    // ddl
    // dml

    private static final String CREATE_TABLE = """
            CREATE TABLE IF NOT EXISTS bike (
            id SERIAL primary key,
            model varchar(30) not null,
            power INT not null,
            price DOUBLE PRECISION not null 
            )
            """;
    private static final String DELETE_TABLE = """
            DROP TABLE IF EXISTS bike;
            """;
    private static final String CLEAN_TABLE = """
            TRUNCATE TABLE bike;
            """;
    private static final String DELETE_SQL = """
            DELETE FROM bike
            WHERE id = ?
            """;
    private static final String FIND_ALL = """
            SELECT id,
                model,
                power,
                price
            FROM bike
            """;
    private static final String FIND_BY_ID = FIND_ALL + """
            WHERE id = ?
            """;
    private static final String SAVE_SQL = """
            INSERT INTO bike (model, power, price) 
            VALUES (?, ?, ?)
            """;

    private static final String UPDATE_SQL = """
            UPDATE bike 
            SET model = ?,
                power = ?,
                price = ?
            WHERE id = ?
            """;
    private BikeDaoImpl(){
    }

    public static BikeDao getBikeDao() {
        return bikeDao;
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
    public Optional<Bike> findById(int id) {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Bike bike = null;

            if (resultSet.next()) {
                bike = buildBike(resultSet);
            }

            // Optional [?]

            return Optional.ofNullable(bike);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(int id) {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)) {
//            DELETE FROM bike
//            WHERE id = ?(id = 1)
            preparedStatement.setInt(1, id);

            // executeUpdate - количество полей в бд которые изменились
            // execute - true / false было ли изменено что либо
            // executeQuery - resultSet(выборка полей)
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
    public List<Bike> findAll() {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Bike> bikes = new ArrayList<>();
            //->//
            // [] id model price
            // [] id model price
            // [] id model price
            // []

            // [bike{id, model}, ]
            while (resultSet.next()) {
                bikes.add(buildBike(resultSet));
            }

            return bikes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Bike> findAll(BikeFilter bikeFilter) {
        return null;
    }

    @Override
    public void update(Bike bike) {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
            preparedStatement.setString(1, bike.getModel());
            preparedStatement.setInt(2, bike.getPower());
            preparedStatement.setDouble(3, bike.getPrice());
            preparedStatement.setInt(4, bike.getId());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Bike save(Bike bike) {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL,
                     Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, bike.getModel());
            preparedStatement.setInt(2, bike.getPower());
            preparedStatement.setDouble(3, bike.getPrice());

            preparedStatement.execute();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                bike.setId(generatedKeys.getInt("id"));
            }

            return bike;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Bike buildBike(ResultSet resultSet) throws SQLException {
        return new Bike(
                resultSet.getInt("id"),
                resultSet.getString("model"),
                resultSet.getInt("power"),
                resultSet.getDouble("price")
        );
    }
}
