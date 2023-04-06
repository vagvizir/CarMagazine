package org.example.service;

import org.example.models.Car;
import org.example.models.Person;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    public List<Car> carDB = new ArrayList<>();

    public void bayCar(Person person, int id) {
        person.money -= carDB.get(id).price;
        carDB.remove(id);
    }
}
