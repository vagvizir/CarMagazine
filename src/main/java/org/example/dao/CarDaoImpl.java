package org.example.dao;

import org.example.models.Car;
import org.example.models.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarDaoImpl implements CarDao {

    List<Car> cars = new ArrayList<>();

    @Override
    public void saveCar(Car... cars) {
        this.cars.addAll(Arrays.asList(cars));
    }

    @Override
    public Car getCar(int carId) {
        return cars.get(carId);
    }

    @Override
    public void deleteCar(int carId) {
        cars.remove(carId);
    }

    @Override
    public void bayCar(Person person, int id) {
        person.setMoney(person.getMoney() - cars.get(id).getPrice());
        cars.remove(id);
    }

    @Override
    public int sizeDB() {
        return cars.size();
    }

    @Override
    public List<Car> getAll() {
        return cars;
    }
}
