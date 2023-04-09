package org.example.service;

import org.example.dao.BikeDao;
import org.example.dao.BikeDaoImpl;
import org.example.models.Bike;
import org.example.models.Person;

import java.util.List;

public class BikeServiceImpl implements BikeService {
    BikeDao bikeDao = new BikeDaoImpl();

    @Override
    public void saveBike(Bike bike) {
        bikeDao.saveBike(bike);
    }

    @Override
    public Bike getBike(int bikeId) {
        return bikeDao.getBike(bikeId);
    }

    @Override
    public void deleteBike(int bikeId) {
        bikeDao.deleteBike(bikeId);
    }

    @Override
    public void buyBike(Person person, int id) {
        bikeDao.buyBike(person, id);
    }

    @Override
    public int sizeDB() {
        return bikeDao.sizeDb();
    }

    @Override
    public List<Bike> getBikes() {
        return bikeDao.getAll();
    }
}
