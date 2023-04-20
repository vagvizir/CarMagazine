package org.example.util;

import org.example.models.Bike;
import org.example.models.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:2222/mysql";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Соединения не установленно");
            throw e;
        }
    }
    public static List<Car> filterCar(List<Car> cars, Predicate<Car> predicate) {
        List<Car> result = new ArrayList<>();

        for (Car car : cars) {
            if (predicate.test(car)) {
                result.add(car);
            }
        }

        return result;
    }

    public static List<Bike> filterBike(List<Bike> bikes, Predicate<Bike> predicate) {
        List<Bike> result = new ArrayList<>();

        for (Bike bike : bikes) {
            if (predicate.test(bike)) {
                result.add(bike);
            }
        }
        return result;
    }

//    public static List<Car> filterCarPowerHorse(List<Car> cars) {
//        List<Car> result = new ArrayList<>();
//
//        for (Car car : cars) {
//            if (car.getPowerHorse() > 200) {
//                result.add(car);
//            }
//        }
//
//        return result;
//    }
//
//    public static List<Car> filterCarPowerHorseAndMoney(List<Car> cars) {
//        List<Car> result = new ArrayList<>();
//
//        for (Car car : cars) {
//            if (car.getPowerHorse() <= 300 && car.getPrice() <= 500_000) {
//                result.add(car);
//            }
//        }
//
//        return result;
//    }

}
