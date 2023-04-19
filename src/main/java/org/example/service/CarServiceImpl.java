package org.example.service;

import org.example.dao.CarDao;
import org.example.dao.CarDaoImpl;
import org.example.models.Car;
import org.example.models.Person;

import java.util.List;

public class CarServiceImpl implements CarService {
    CarDao carDao = new CarDaoImpl();

    @Override
    public void saveCar(Car... cars) {
        carDao.saveCar(cars);
    }

    @Override
    public Car getCar(int carId) {
        return carDao.getCar(carId);
    }

    @Override
    public void deleteCar(int carId) {
        carDao.deleteCar(carId);
    }

    @Override
    public Car getMaxCarPrice() {
        return carDao.getMaxCarPrice();
    }

    @Override
    public Car getMinCarPrice() {
        return carDao.getMinCarPrice();
    }

    @Override
    public Car getMaxCarPower() {
        return carDao.getMaxCarPower();
    }

    @Override
    public Car getMinCarPower() {
        return carDao.getMinCarPower();
    }

    @Override
    public void bayCar(Person person, int id) {
        carDao.bayCar(person, id);
    }

    @Override
    public int sizeDB() {
        return carDao.sizeDB();
    }

    @Override
    public List<Car> getCars() {
        return carDao.getAll();
    }
}
