package org.example.dao;

import org.example.models.Bike;
import org.example.models.Person;

import java.util.ArrayList;
import java.util.List;

public class BikeDaoImpl implements BikeDao {
    List <Bike> bikes = new ArrayList<>();

    @Override
    public void saveBike(Bike bike) {
        bikes.add(bike);
    }

    @Override
    public Bike getBike(int bikeId) {
        return bikes.get(bikeId);
    }

    @Override
    public void deleteBike(int bikeId) {
        bikes.remove(bikeId);
    }

    @Override
    public void buyBike(Person person, int id) {
        person.money -= bikes.get(id).price;
        bikes.remove(id);
    }

    @Override
    public int sizeDb() {
        return bikes.size();
    }

    @Override
    public List<Bike> getAll() {
        return bikes;
    }
}
