package org.example.dao;

import org.example.models.Bike;
import org.example.models.Car;

import java.util.List;

public interface CarDaoJdbc {
    void createTable();
    void dropTable();
    void cleanTable();
    Car getCar(int id);
    void deleteCar(int id);
    void deleteCar(String name);
    List<Car> getAllCars();
    void saveCar(Car car);
}
