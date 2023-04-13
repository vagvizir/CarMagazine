package org.example.service;

import org.example.models.Person;

public interface PersonService {
    void savePerson(Person... persons);
    Person getPerson(int personId);
    void deletePerson(int personId);
    Person getMaxMoneyPerson();
    Person getMinMoneyPerson();
}
