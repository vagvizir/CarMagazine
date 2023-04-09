package org.example.dao;

import org.example.models.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao {
    List<Person> personDB = new ArrayList<>();

    @Override
    public void savePerson(Person person) {
        personDB.add(person);
    }

    @Override
    public Person getPerson(int personId) {
        return personDB.get(personId);
    }

    @Override
    public void deletePerson(int personId) {
        personDB.remove(personId);
    }
}
