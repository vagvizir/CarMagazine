package org.example.service;

import org.example.dto.BikeFilter;
import org.example.models.Bike;
import org.example.models.Person;

import java.util.List;
import java.util.Optional;

public interface BikeService {
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
