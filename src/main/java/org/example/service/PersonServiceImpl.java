package org.example.service;

import org.example.dao.PersonDao;
import org.example.dao.PersonDaoImpl;
import org.example.dto.PersonFilter;
import org.example.models.Person;

import java.util.List;
import java.util.Optional;

public class PersonServiceImpl implements PersonService {
    PersonDao personDao = PersonDaoImpl.getPersonDao();
    @Override
    public boolean createTable() {
        return personDao.createTable();
    }

    @Override
    public boolean dropTable() {
        return personDao.dropTable();
    }

    @Override
    public void cleanTable() {
        personDao.cleanTable();
    }

    @Override
    public Optional<Person> findById(int id) {
        return personDao.findById(id);
    }

    @Override
    public boolean delete(int id) {
        return personDao.delete(id);
    }

    @Override
    public boolean delete(String name) {
        return personDao.delete(name);
    }

    @Override
    public List<Person> findAll() {
        return personDao.findAll();
    }

    @Override
    public List<Person> findAll(PersonFilter personFilter) {
        return personDao.findAll(personFilter);
    }

    @Override
    public void update(Person person) {
        personDao.update(person);
    }

    @Override
    public Person save(Person person) {
        return personDao.save(person);
    }
}
