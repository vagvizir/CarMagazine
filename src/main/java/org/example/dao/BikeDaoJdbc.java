package org.example.dao;

import org.example.models.Bike;
import org.example.util.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public interface BikeDaoJdbc {
    void createTable();
    void dropTable();
    void cleanTable();
    Bike getBike(int id);
    void deleteBike(int id);
    void deleteBike(String name);
    List<Bike> getAllBikes();
    void saveBike(Bike bike);
}
