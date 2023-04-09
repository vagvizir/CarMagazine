package org.example.dao;

import org.example.models.Person;

public interface PersonDao {
    void savePerson(Person person);
    Person getPerson(int personId);
    void deletePerson(int personId);
}
