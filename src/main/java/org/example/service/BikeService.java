package org.example.service;

import org.example.models.Bike;
import org.example.models.Person;

import java.util.List;

public interface BikeService {
    void saveBike(Bike... bikes);
    Bike getBike(int bikeId);
    void deleteBike(int bikeId);
    Bike getMaxBikePrice();
    Bike getMinBikePrice();
    Bike getMaxBikePower();
    Bike getMinBikePower();
    void buyBike(Person person, int id);
    int sizeDB();
    List<Bike> getBikes();
}
