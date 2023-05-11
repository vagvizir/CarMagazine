package org.example.dao;

import org.example.models.Car;
import org.example.models.Person;

import java.util.List;

public interface PersonDaoJdbc {
    void createTable();
    void dropTable();
    void cleanTable();
    Person getPerson(int id);
    void deletePerson(int id);
    void deletePerson(String name);
    List<Person> getAllPersons();
    void savePerson(Person person);
}
