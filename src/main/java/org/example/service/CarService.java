package org.example.service;

import org.example.dao.CarDao;
import org.example.dao.CarDaoImpl;
import org.example.models.Car;
import org.example.models.Person;

import java.util.ArrayList;
import java.util.List;

public interface CarService {
    public void saveCar(Car car);
    public Car getCar(int carId);
    public void deleteCar(int carId);
    public void bayCar(Person person, int id);
}
