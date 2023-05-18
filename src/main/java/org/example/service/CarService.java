package org.example.service;

import org.example.dao.CarDao;
import org.example.dao.CarDaoImpl;
import org.example.dto.CarFilter;
import org.example.models.Bike;
import org.example.models.Car;
import org.example.models.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface CarService {
    boolean createTable();
    boolean dropTable();
    void cleanTable();
    Optional<Car> findById(int id);
    boolean delete(int id);
    boolean delete(String model);
    List<Car> findAll();
    List<Car> findAll(CarFilter carFilter);
    void update(Car car);
    Car save(Car car);
}
