package org.example.dao;

import org.example.dto.BikeFilter;
import org.example.dto.CarFilter;
import org.example.models.Bike;
import org.example.models.Car;
import org.example.models.Person;

import java.util.List;
import java.util.Optional;

public interface CarDao {
    boolean createTable();
    boolean dropTable();
    void cleanTable();
    Optional<Car> findById(int id);
    boolean delete(int id);
    boolean delete(String name);
    List<Car> findAll();
    List<Car> findAll(CarFilter carFilter);
    void update(Car car);
    Car save(Car car);
}
