package org.example.dao;

import org.example.models.Car;
import org.example.models.Person;

public interface CarDao {
    public void saveCar(Car car);
    public Car getCar(int carId);
    public void deleteCar(int carId);
    public void bayCar(Person person, int id);

}
