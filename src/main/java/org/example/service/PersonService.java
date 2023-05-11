package org.example.service;

import org.example.dto.PersonFilter;
import org.example.models.Bike;
import org.example.models.Car;
import org.example.models.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    boolean createTable();
    boolean dropTable();
    void cleanTable();
    Optional<Person> findById(int id);
    boolean delete(int id);
    boolean delete(String name);
    List<Person> findAll();
    List<Person> findAll(PersonFilter personFilter);
    void update(Person person);
    Person save(Person person);
}
