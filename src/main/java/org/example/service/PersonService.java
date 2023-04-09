package org.example.service;

import org.example.models.Person;

public interface PersonService {
    void savePerson(Person person);
    Person getPerson(int personId);
    void deletePerson(int personId);
}
