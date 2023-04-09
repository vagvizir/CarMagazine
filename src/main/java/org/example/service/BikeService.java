package org.example.service;

import org.example.models.Bike;
import org.example.models.Person;

import java.util.List;

public interface BikeService {
    void saveBike(Bike bike);
    Bike getBike(int bikeId);
    void deleteBike(int bikeId);
    void buyBike(Person person, int id);
    int sizeDB();
    List<Bike> getBikes();
}
