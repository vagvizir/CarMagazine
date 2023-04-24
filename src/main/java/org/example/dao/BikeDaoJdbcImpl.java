package org.example.dao;

import org.example.models.Bike;
import org.example.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BikeDaoJdbcImpl {
    public void createTable() {
        try (Statement statement = Util.getConnection().createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS bikes (id BIGINT PRIMARY KEY AUTO_INCREMENT, " +
                    "model VARCHAR(45), price DOUBLE, power INT)");
            System.out.println("Таблица bikes создана!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropTable() {
        try (Statement statement = Util.getConnection().createStatement()) {
            statement.execute("DROP TABLE IF EXISTS bikes");
            System.out.println("Таблица bikes удалена!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cleanTable() {
        try (Statement statement = Util.getConnection().createStatement()) {
            statement.execute("TRUNCATE TABLE bikes");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Bike getBike(int id) {
        try (Statement statement = Util.getConnection().createStatement()) {
            // execute - true / false
            // executeQuery - ResultSet
            ResultSet resultSet = statement.executeQuery("SELECT * FROM bikes WHERE id = " + id);
            // 1 1_000_000 BMW 300

            resultSet.next();

            Bike bike = new Bike();

            bike.setModel(resultSet.getString(2));
            bike.setPrice(resultSet.getDouble(3));
            bike.setPower(resultSet.getInt(4));

            return bike;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteBike(int id) {
        try (PreparedStatement statement = Util.getConnection()
                .prepareStatement("DELETE FROM bikes WHERE id=?")) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteBike(String name) {
        try (PreparedStatement statement = Util.getConnection()
                .prepareStatement("DELETE FROM bikes WHERE model=?")) {
            statement.setString(1, name);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Bike> getAllBikes() {
        try (Statement statement = Util.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM bikes");

            List<Bike> result = new ArrayList<>();

            while (resultSet.next()) {
                Bike bike = new Bike();

                bike.setModel(resultSet.getString(2));
                bike.setPrice(resultSet.getDouble(3));
                bike.setPower(resultSet.getInt(4));

                result.add(bike);
            }

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//            "model VARCHAR(45), price DOUBLE, power INT
    public void saveBike(Bike bike) {
        try (PreparedStatement statement = Util.getConnection()
                .prepareStatement("INSERT INTO bikes (model, price, power) VALUES (?, ?, ?)")) {
            statement.setString(1, bike.getModel());
            statement.setDouble(2, bike.getPrice());
            statement.setInt(3, bike.getPower());

            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
