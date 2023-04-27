package org.example.service;

import org.example.models.Bike;
import org.example.models.Person;

import java.util.List;

public interface BikeService {
    void createTable();
    void dropTable();
    void cleanTable();
    Bike getBike(int id);
    void deleteBike(int id);
    void deleteBike(String name);
    List<Bike> getAllBikes();
    void saveBike(Bike bike);
}
