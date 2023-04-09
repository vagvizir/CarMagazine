package org.example.dao;

import org.example.models.Bike;
import org.example.models.Person;

import java.util.List;

public interface BikeDao {
    void saveBike(Bike bike);
    Bike getBike(int bikeId);
    void deleteBike(int bikeId);
    void buyBike(Person person, int id);
    int sizeDb();
    List<Bike> getAll();
}
