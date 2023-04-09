package org.example.dao;

import org.example.models.Person;

public interface PersonDao {
    public void savePerson(Person person);
    public Person getPerson(int personId);
    public void deletePerson(int personId);
}
