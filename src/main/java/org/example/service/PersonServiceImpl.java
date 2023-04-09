package org.example.service;

import org.example.dao.PersonDaoImpl;
import org.example.models.Person;

public class PersonServiceImpl implements PersonService {
    PersonDaoImpl personDao = new PersonDaoImpl();

    @Override
    public void savePerson(Person person) {
        personDao.savePerson(person);
    }

    @Override
    public Person getPerson(int personId) {
        return personDao.getPerson(personId);
    }

    @Override
    public void deletePerson(int personId) {
        personDao.deletePerson(personId);
    }
}
