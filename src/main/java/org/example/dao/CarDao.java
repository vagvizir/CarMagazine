package org.example.dao;

import org.example.models.Car;
import org.example.models.Person;

import java.util.List;

public interface CarDao {
    void saveCar(Car car);
    Car getCar(int carId);
    void deleteCar(int carId);
    void bayCar(Person person, int id);
    int sizeDB();
    List<Car> getAll();

}
