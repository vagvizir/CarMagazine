package org.example.service;

import org.example.dao.CarDao;
import org.example.dao.CarDaoImpl;
import org.example.models.Car;
import org.example.models.Person;

public class CarServiceImpl implements CarService {
    CarDao carDao = new CarDaoImpl();

    @Override
    public void saveCar(Car car) {
        carDao.saveCar(car);
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
    public void bayCar(Person person, int id) {
        carDao.bayCar(person, id);
    }
}
