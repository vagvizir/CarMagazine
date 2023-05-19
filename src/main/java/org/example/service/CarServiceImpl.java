package org.example.service;

import org.example.dao.CarDao;
import org.example.dao.CarDaoImpl;
import org.example.dto.CarFilter;
import org.example.models.Car;

import java.util.List;
import java.util.Optional;

public class CarServiceImpl implements CarService {
    CarDao carDao = CarDaoImpl.getCarDao();
    @Override
    public boolean createTable() {
        return carDao.createTable();
    }

    @Override
    public boolean dropTable() {
        return carDao.dropTable();
    }

    @Override
    public void cleanTable() {
        carDao.cleanTable();
    }

    @Override
    public Optional<Car> findById(int id) {
        return carDao.findById(id);
    }

    @Override
    public boolean delete(int id) {
        return carDao.delete(id);
    }

    @Override
    public boolean delete(String model) {
        return carDao.delete(model);
    }

    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }

    @Override
    public List<Car> findAll(CarFilter carFilter) {
        return carDao.findAll(carFilter);
    }

    @Override
    public void update(Car car) {
        carDao.update(car);
    }

    @Override
    public Car save(Car car) {
        return carDao.save(car);
    }
}
