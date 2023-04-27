package org.example.service;

import org.example.dao.BikeDaoJdbc;
import org.example.dao.BikeDaoJdbcImpl;
import org.example.models.Bike;
import java.util.List;

public class BikeServiceImpl implements BikeService {
    BikeDaoJdbc bikeDao = new BikeDaoJdbcImpl();

    @Override
    public void createTable() {
        bikeDao.createTable();
    }

    @Override
    public void dropTable() {
        bikeDao.dropTable();
    }

    @Override
    public void cleanTable() {
        bikeDao.cleanTable();
    }

    @Override
    public Bike getBike(int id) {
        return bikeDao.getBike(id);
    }

    @Override
    public void deleteBike(int id) {
        bikeDao.deleteBike(id);
    }

    @Override
    public void deleteBike(String name) {
        bikeDao.deleteBike(name);
    }

    @Override
    public List<Bike> getAllBikes() {
        return bikeDao.getAllBikes();
    }

    @Override
    public void saveBike(Bike bike) {
        bikeDao.saveBike(bike);
    }
}
