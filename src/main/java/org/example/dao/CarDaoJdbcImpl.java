package org.example.dao;

import org.example.models.Car;
import org.example.util.ConnectionManager;
import org.example.util.ModelsFilter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDaoJdbcImpl implements CarDaoJdbc {

    @Override
    public void createTable() {
        try (Statement statement = ConnectionManager.open().createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS cars (id INT PRIMARY KEY AUTO_INCREMENT," +
                            "name VARCHAR(45), power_horse INT, price DOUBLE)");
            System.out.println("таблица cars создана");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void dropTable() {
        try (Statement statement = ConnectionManager.open().createStatement()) {
            statement.execute("DROP TABLE IF EXISTS cars");
            System.out.println("таблица car удалена");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void cleanTable() {
        try (Statement statement = ConnectionManager.open().createStatement()) {
            statement.execute("TRUNCATE TABLE cars");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Car getCar(int id) { // написать через prepareStatement
        try (Statement statement = ConnectionManager.open().createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM cars WHERE id = " + id);

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
        try (PreparedStatement statement = ConnectionManager.open()
                .prepareStatement("DELETE FROM cars WHERE id=?")) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteCar(String model) {
        try (PreparedStatement statement = ConnectionManager.open()
                .prepareStatement("DELETE FROM cars WHERE id = ?")) {
            statement.setInt(1, 2);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
