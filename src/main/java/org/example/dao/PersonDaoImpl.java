package org.example.dao;

import org.example.models.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonDaoImpl implements PersonDao {
    List<Person> personDB = new ArrayList<>();

    @Override
    public void savePerson(Person... persons) {
        personDB.addAll(Arrays.asList(persons));
    }

    @Override
    public Person getPerson(int personId) {
        return personDB.get(personId);
    }

    @Override
    public void deletePerson(int personId) {
        personDB.remove(personId);
    }

    @Override
    public Person getMaxMoneyPerson() {
        personDB.sort((p1, p2) -> Double.compare(p1.getMoney(), p2.getMoney()));

        return personDB.get(personDB.size() - 1);
    }

    @Override
    public Person getMinMoneyPerson() {
        personDB.sort((p1, p2) -> Double.compare(p1.getMoney(), p2.getMoney()));

        return personDB.get(0);
    }
}
