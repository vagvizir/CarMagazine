package org.example.dao;

import org.example.models.Bike;
import org.example.models.Person;

import java.util.List;

public interface BikeDao {
    void saveBike(Bike... bikes);
    Bike getBike(int bikeId);
    void deleteBike(int bikeId);
    void buyBike(Person person, int id);
    int sizeDb();
    Bike getMaxBikePrice();
    Bike getMinBikePrice();
    Bike getMaxBikePower();
    Bike getMinBikePower();
    List<Bike> getAll();
}
