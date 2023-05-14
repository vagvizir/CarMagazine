package org.example.dao;

import org.example.dto.CarFilter;
import org.example.models.Bike;
import org.example.models.Car;
import org.example.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarDaoImpl implements CarDao {

    private static final CarDao carDao = new CarDaoImpl();

    private static final String CREATE_TABLE = """
            CREATE TABLE IF NOT EXISTS car (
            id SERIAL primary key,
            model varchar(30) not null,
            powerHorse INT not null,
            price DOUBLE PRECISION not null 
            )
            """;
    private static final String DELETE_TABLE = """
            DROP TABLE IF EXIST car;
            """;
    private static final String CLEAN_TABLE = """
            TRUNCATE TABLE car;
            """;
    private static final String DELETE_SQL = """
            DELETE FROM car
            WHERE id = ?
            """;
    private static final String FIND_ALL = """
            SELECT id,
                model,
                powerHorse,
                price
            FROM car
            """;
    private static final String FIND_BY_ID = FIND_ALL + """
            WHERE id = ?
            """;
    private static final String SAVE_SQL = """
            INSERT INTO car (model, powerHorse, price) 
            VALUES (?, ?, ?)
            """;
    private static final String UPDATE_SQL = """
            UPDATE car 
            SET model = ?,
                powerHorse = ?,
                price = ?
            WHERE id = ?
            """;
    private CarDaoImpl() {
    }

    public static CarDao getCarDao() {
        return carDao;
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
    public Optional<Car> findById(int id) {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Car car = null;

            if (resultSet.next()) {
                car = buildCar(resultSet);
            }

            // Optional [?]

            return Optional.ofNullable(car);
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
    public List<Car> findAll() {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Car> cars = new ArrayList<>();

            while (resultSet.next()) {
                cars.add(buildCar(resultSet));
            }

            return cars;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Car> findAll(CarFilter carFilter) {
        return null;
    }

    @Override
    public void update(Car car) {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
            preparedStatement.setString(1, car.getModel());
            preparedStatement.setInt(2, car.getPowerHorse());
            preparedStatement.setDouble(3, car.getPrice());
            preparedStatement.setInt(4, car.getId());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Car save(Car car) {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL,
                     Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, car.getModel());
            preparedStatement.setInt(2, car.getPowerHorse());
            preparedStatement.setDouble(3, car.getPrice());

            preparedStatement.execute();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                car.setId(generatedKeys.getInt("id"));
            }

            return car;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Car buildCar(ResultSet resultSet) throws SQLException {
        return new Car(
                resultSet.getInt("id"),
                resultSet.getString("model"),
                resultSet.getInt("powerHorse"),
                resultSet.getDouble("price")
        );
    }
}
