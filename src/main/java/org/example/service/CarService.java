package org.example.service;

import org.example.dao.CarDao;
import org.example.dao.CarDaoImpl;
import org.example.models.Car;
import org.example.models.Person;

import java.util.ArrayList;
import java.util.List;

public interface CarService {
    void saveCar(Car... cars);
    Car getCar(int carId);
    void deleteCar(int carId);
    Car getMaxCarPrice();
    Car getMinCarPrice();
    Car getMaxCarPower();
    Car getMinCarPower();
    void bayCar(Person person, int id);
    int sizeDB();
    List<Car> getCars();
}
