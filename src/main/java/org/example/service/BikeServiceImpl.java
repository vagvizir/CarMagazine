package org.example.service;

import org.example.dao.BikeDao;
import org.example.dao.BikeDaoImpl;
import org.example.dto.BikeFilter;
import org.example.models.Bike;

import java.util.List;
import java.util.Optional;

public class BikeServiceImpl implements BikeService {
    BikeDao bikeDao = BikeDaoImpl.getBikeDao();
    @Override
    public boolean createTable() {

        return bikeDao.createTable();
    }

    @Override
    public boolean dropTable() {

        return bikeDao.dropTable();
    }

    @Override
    public void cleanTable() {
        bikeDao.cleanTable();
    }

    @Override
    public Optional<Bike> findById(int id) {
        return bikeDao.findById(id);
    }

    @Override
    public boolean delete(int id) {
        return bikeDao.delete(id);
    }

    @Override
    public boolean delete(String name) {
        return bikeDao.delete(name);
    }

    @Override
    public List<Bike> findAll() {
        return bikeDao.findAll();
    }

    @Override
    public List<Bike> findAll(BikeFilter bikeFilter) {
        return bikeDao.findAll(bikeFilter);
    }

    @Override
    public void update(Bike bike) {
        bikeDao.update(bike);
    }

    @Override
    public Bike save(Bike bike) {
        return bikeDao.save(bike);
    }
}
