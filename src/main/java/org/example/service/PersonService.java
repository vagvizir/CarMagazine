package org.example.service;

import org.example.models.Person;

public interface PersonService {
    public void savePerson(Person person);
    public Person getPerson(int personId);
    public void deletePerson(int personId);
}
