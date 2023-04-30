package org.example.dao;

import org.example.models.Car;
import org.example.util.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CarDaoJdbcImpl implements CarDaoJdbc {

    @Override
    public void createTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS car (
                id INT PRIMARY KEY AUTO_INCREMENT,
                name VARCHAR(45),
                power_horse INT,
                price DOUBLE
                )
                """;
        try (Statement statement = ConnectionManager.open().createStatement()) {
            statement.execute(sql);
            System.out.println("таблица car создана");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void dropTable() {
        try (Statement statement = ConnectionManager.open().createStatement()) {
            statement.execute("DROP TABLE IF EXISTS car");
            System.out.println("таблица car удалена");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void cleanTable() {
        try (Statement statement = ConnectionManager.open().createStatement()) {
            statement.execute("TRUNCATE TABLE car");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Car getCar(int id) { // напмсать через prepareStatement
        try (Statement statement = ConnectionManager.open().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM car WHERE id = " + id);
            resultSet.next();
            Car car = new Car();
            car.setName(resultSet.getString("name"));
            car.setPowerHorse(resultSet.getInt("power_horse"));
            car.setPrice(resultSet.getDouble("price"));
            return car;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteCar(int id) {

    }

    @Override
    public void deleteCar(String name) {

    }

    @Override
    public List<Car> getAllCars() {
        return null;
    }

    @Override
    public void saveCar(Car car) {
        try (PreparedStatement statement = ConnectionManager.open().prepareStatement
                ("INSERT INTO car (name, power_horse, price) VALUES (?, ?, ?)")) {
            statement.setString(1, car.getName());
            statement.setInt(2, car.getPowerHorse());
            statement.setDouble(3, car.getPrice());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
