package org.example.dao;

import org.example.models.Car;
import org.example.models.Person;

import java.util.List;

public interface CarDao {
    void saveCar(Car... cars);
    Car getCar(int carId);
    void deleteCar(int carId);
    void bayCar(Person person, int id);
    int sizeDB();
    Car getMaxCarPrice();
    Car getMinCarPrice();
    Car getMaxCarPower();
    Car getMinCarPower();
    List<Car> getAll();

}
