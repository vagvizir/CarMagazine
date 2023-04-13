package org.example.service;

import org.example.dao.PersonDao;
import org.example.dao.PersonDaoImpl;
import org.example.models.Person;

public class PersonServiceImpl implements PersonService {
    PersonDao personDao = new PersonDaoImpl();

    @Override
    public void savePerson(Person... persons) {
        personDao.savePerson(persons);
    }

    @Override
    public Person getPerson(int personId) {
        return personDao.getPerson(personId);
    }

    @Override
    public void deletePerson(int personId) {
        personDao.deletePerson(personId);
    }

    @Override
    public Person getMaxMoneyPerson() {
        return personDao.getMaxMoneyPerson();
    }

    @Override
    public Person getMinMoneyPerson() {
        return personDao.getMinMoneyPerson();
    }
}
