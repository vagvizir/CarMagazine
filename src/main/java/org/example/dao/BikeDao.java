package org.example.dao;

import org.example.dto.BikeFilter;
import org.example.models.Bike;

import java.util.List;
import java.util.Optional;

// CRUD
    // Create Read Update Delete
public interface BikeDao {
    boolean createTable();
    boolean dropTable();
    void cleanTable();
    Optional<Bike> findById(int id);
    boolean delete(int id);
    boolean delete(String name);
    List<Bike> findAll();
    List<Bike> findAll(BikeFilter bikeFilter);
    void update(Bike bike);
    Bike save(Bike bike);
}
